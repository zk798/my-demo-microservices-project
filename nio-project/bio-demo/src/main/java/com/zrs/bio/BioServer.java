package com.zrs.bio;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class BioServer {


    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket();
        serverSocket.bind(new InetSocketAddress("127.0.0.1",8888));

        while(true){
            Socket accept = serverSocket.accept();
            InputStream inputStream = accept.getInputStream();
            byte[] buff = new byte[1024];
            int size;
            while((size = inputStream.read(buff))!=-1){
                System.out.println(new String(buff,0,size));
            }
        }


    }
}
