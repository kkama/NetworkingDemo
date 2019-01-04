package com.kaminsky;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class HttpURLConnectionDemo {

    public static void main(String[] args) throws IOException {

        URL hp = new URL("http://www.google.com");
        HttpURLConnection h = (HttpURLConnection) hp.openConnection();

        System.out.println(h.getRequestMethod());
        System.out.println(h.getResponseCode());
        System.out.println(h.getResponseMessage());

        Map<String, List<String>> map = h.getHeaderFields();
        Set<Map.Entry<String, List<String>>> set = map.entrySet();

        for (Map.Entry<String, List<String>> a : set) {
            System.out.println(a);
        }

    }

}
