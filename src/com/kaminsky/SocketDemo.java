package com.kaminsky;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

// You have to create a Socket and setup InputStream and OutputStream

public class SocketDemo {

    public static void main(String[] args) throws IOException {

        InetAddress address1 = InetAddress.getLocalHost();
        InetAddress address2 = InetAddress.getByName("www.google.com");

        System.out.println(address1 + " " + address2);

        int c;

        // Create Socker
        Socket s = new Socket("whois.internic.net", 43);

        // Create InputStream
        InputStream in = s.getInputStream();
        // Create OutputStream
        OutputStream out = s.getOutputStream();

        String str = (args.length == 0 ? "OraclePressBook.com" : args[0]) + "\n";
        byte[] buf = str.getBytes();

        out.write(buf);
        while ((c = in.read()) != -1) {
            System.out.print((char) c);
        }
        s.close();
    }
}
