package com.zrs.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class NioClient {


    public static void main(String[] args) throws IOException {

        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1",9001));
        socketChannel.configureBlocking(false);
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        if(socketChannel.isConnected()) {

            byteBuffer.put("hihao bio".getBytes());
            byteBuffer.flip();
            while(byteBuffer.hasRemaining()) {
                socketChannel.write(byteBuffer);
            }
        }
        socketChannel.close();


    }
}
