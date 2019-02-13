package com.zrs.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.util.Iterator;
import java.util.Set;

/**
 *
 */
public class NioServerUseSelector {

    public static void main(String[] args) throws IOException {

        Selector selector = Selector.open();
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.bind(new InetSocketAddress("127.0.0.1",9001));
        serverSocketChannel.register(selector,SelectionKey.OP_ACCEPT);

        while(true){
            if(selector.select(100) == 0 ){
                continue;
            }
            Iterator<SelectionKey> iter = selector.selectedKeys().iterator();
            while(iter.hasNext()){
                SelectionKey selectionKey = iter.next();
                if(selectionKey.isAcceptable()){
                    accept(selectionKey);
                }
                if(selectionKey.isReadable()){
                    read(selectionKey);
                }
                iter.remove();
            }
        }

    }

    private static void accept(SelectionKey selectionKey) throws IOException {

        ServerSocketChannel serverSocketChannel = (ServerSocketChannel) selectionKey.channel();
        SocketChannel sc = serverSocketChannel.accept();
        if(sc != null) {
            sc.configureBlocking(false);
            sc.register(selectionKey.selector(), SelectionKey.OP_READ);
        }
    }


    public  static void read(SelectionKey selectionKey) throws IOException {
        SocketChannel channel = (SocketChannel)selectionKey.channel();
        ByteBuffer buf = ByteBuffer.allocate(1024);
        int bytesRead = channel.read(buf);
        while(bytesRead>0){
            buf.flip();
            while(buf.hasRemaining()){
                System.out.print((char)buf.get());
            }
            System.out.println();
            buf.clear();
            bytesRead = channel.read(buf);
        }
        if(bytesRead == -1){
            channel.close();
        }
    }
}