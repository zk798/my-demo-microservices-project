package com.zrs.bio;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class BioClient {

    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("127.0.0.1",8888);

        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("nihao".getBytes());
        outputStream.close();
        socket.close();

    }
}
