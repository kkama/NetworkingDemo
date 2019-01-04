package com.kaminsky;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class URLConnectionDemo {

    public static void main(String[] args) throws IOException {

        int c;
        URL hp = new URL("http://homelogic.co.uk");
        URLConnection hpCon = hp.openConnection();

        long d = hpCon.getDate();
        System.out.println(new Date(d));

        System.out.println(hpCon.getContentType());
        System.out.println(new Date(hpCon.getExpiration()));
        System.out.println(new Date(hpCon.getLastModified()));
        System.out.println(hpCon.getContentLength());

        System.out.println();

        Map<String, List<String>> newmap = hpCon.getHeaderFields();
        Set<Map.Entry<String, List<String>>> set = newmap.entrySet();

        for (Map.Entry<String, List<String>> a : set) {
            System.out.println(a);
        }

//        InputStream in = hpCon.getInputStream();
//        while ((c = in.read()) != -1) {
//            System.out.print((char)c);
//        }
//        in.close();

    }

}
