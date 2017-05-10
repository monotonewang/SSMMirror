package com.demo.webservice.serversocket;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by wang on 17-5-2.
 */
public class TestSocketServer {
    public  static void main(String args[]) throws IOException {
        //create service interface
        ServerSocket ss=new ServerSocket(8888);
        //accept request
        Socket s=ss.accept();
        //get the
        String result=new PersonService().sayHello();
        OutputStream outputStream=s.getOutputStream();
        outputStream.write(result.getBytes());
    }
}
