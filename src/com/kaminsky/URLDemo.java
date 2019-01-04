package com.kaminsky;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class URLDemo {

    public static void main(String[] args) throws IOException {

        URL url = new URL("http://www.wp.pl");
        System.out.println("Protocol: " +url.getProtocol());
        System.out.println("Host: " +url.getHost());
        System.out.println("Path: " +url.getPath());
        System.out.println("Authority: " +url.getAuthority());
        System.out.println("Content: " +url.getContent());
        System.out.println("Port: " + url.getPort());
        System.out.println("External form: " + url.toExternalForm());
        System.out.println("File : " + url.getFile());

        url.openConnection();

    }

}
