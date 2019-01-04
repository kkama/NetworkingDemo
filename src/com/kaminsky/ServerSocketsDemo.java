package com.kaminsky;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;

public class ServerSocketsDemo {

    public static void main(String[] args) throws IOException {

        ServerSocket s = new ServerSocket(666, 50, InetAddress.getLocalHost());
        System.out.println(s.getInetAddress());
        System.out.println(s.accept());
        System.out.println(s.getChannel());

    }
}
