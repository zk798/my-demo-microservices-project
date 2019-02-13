package com.zrs.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;

/**
 * @author 闪电侠
 */
public class NioServer {
    public static void main(String[] args) throws IOException {

        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.bind(new InetSocketAddress("127.0.0.1",9900));

        while(true) {
            SocketChannel socketChannel = serverSocketChannel.accept();
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            if (socketChannel!= null) {
                socketChannel.read(byteBuffer);
                byteBuffer.flip();
                if (byteBuffer.hasRemaining()) {
                    System.out.println(Charset.defaultCharset().newDecoder().decode(byteBuffer).toString());
                }
            }
        }


    }
}