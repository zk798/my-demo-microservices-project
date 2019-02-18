package com.zrs.nio.v2;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;

public class NioClient {

    public static void main(String[] args) throws IOException {

        Selector selector  = Selector.open();
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.configureBlocking(false);
        socketChannel.register(selector, SelectionKey.OP_READ | SelectionKey.OP_WRITE);
        socketChannel.connect(new InetSocketAddress("127.0.0.1",7000));


        /*等待三次握手完成*/
        while(!socketChannel.finishConnect()){

        }


        while(true) {

            int n = selector.select();
//            if(n == 0){
//                continue;
//            }

            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            if (iterator.hasNext()){
                SelectionKey key = iterator.next();
                iterator.remove();


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

                    /*取消通道的写事件*/
                    key.interestOps(key.interestOps() & (~SelectionKey.OP_WRITE));

                }

                if(key.isWritable()){
//                    if(socketChannel.isConnected()) {
                        SocketChannel sc = (SocketChannel)key.channel();
                        ByteBuffer byteBuffer = ByteBuffer.allocate(256);
                        byteBuffer.put("hihao bio".getBytes());
                        byteBuffer.flip();
                        while(byteBuffer.hasRemaining()) {
                            sc.write(byteBuffer);
                        }
//                    }
                }

            }
        }

    }
}
