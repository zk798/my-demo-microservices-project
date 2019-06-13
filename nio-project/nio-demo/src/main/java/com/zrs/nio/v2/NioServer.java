package com.zrs.nio.v2;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;

public class NioServer {


    public static void main(String[] args) throws IOException {

        Selector selector  = Selector.open();
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.bind(new InetSocketAddress("127.0.0.1",7000));
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        while(true) {

            int n = selector.select();
            if(n == 0){
                System.out.print(0);
                continue;
            }

            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            if (iterator.hasNext()){
                SelectionKey key = iterator.next();
                iterator.remove();

                if(key.isAcceptable()){
                    ServerSocketChannel ssc = serverSocketChannel;//(ServerSocketChannel)key.channel();
                    //阻塞到数据
                    SocketChannel sc = ssc.accept();
                    sc.configureBlocking(false);
                    sc.register(key.selector(),SelectionKey.OP_READ);
                }

                if(key.isReadable()){
                    SocketChannel sc = (SocketChannel)key.channel();
                    ByteBuffer byteBuffer = ByteBuffer.allocate(256);
                    int read = sc.read(byteBuffer);
                    if(read>0){
                        byteBuffer.flip();
                        while(byteBuffer.hasRemaining()){
                            System.out.println(Charset.defaultCharset().newDecoder().decode(byteBuffer));
                        }
                    }

                    ByteBuffer writeBuffer = ByteBuffer.allocate(256);
                    writeBuffer.put("收到了".getBytes());
                    writeBuffer.flip();
                    sc.write(writeBuffer);

                }

            }
        }

    }
}
