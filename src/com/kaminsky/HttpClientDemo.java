package com.kaminsky;

// HttpClient - Encapsulates an HTTP client. You use it to send a request and obtain a response.
// HttpRequest - Encapsulates a request.
// HttpResponse - Encapsulates a response.

// HttpClient doesn't have a public constructors, you have to use factory methods.
// Use HttpClient.Builder - nested interface

// 1. Create and insstance of HttpClient then...
// 2. Construct an HttpRequest and send it by calling send() on the HttpClient
// 3. The response is returned by send()

import java.io.InputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class HttpClientDemo {
    public static void main(String[] args) throws Exception {

        HttpClient hc = HttpClient.newBuilder().build();

        // You can configure the builder before creating it.
        HttpClient.Builder myBuilder = HttpClient.newBuilder().followRedirects(HttpClient.Redirect.NORMAL);
        HttpClient hc2 = myBuilder.build();

        // If the default http client is sufficient you can simply call..
        HttpClient hc3 = HttpClient.newHttpClient();

        // Create a request.
        HttpRequest myReq = HttpRequest.newBuilder(new URI("http://www.leangains.com/")).build();

        // Send the request and get the response. Instead of InputStream we can also use Path or String for example.
        HttpResponse<InputStream> myRes = hc3.send(myReq, HttpResponse.BodyHandlers.ofInputStream());

        System.out.println(myRes.statusCode());
        System.out.println(myReq.method());

        // Get headers
        HttpHeaders hdrs = myRes.headers();

        // Get a map of headers.
        Map <String, List<String>> hdrMap = hdrs.map();
        Set <Map.Entry<String, List<String>>> set = hdrMap.entrySet();
        for (Map.Entry<String, List<String>> a : set) {
            System.out.println(a);
        }

        // Display the body
        System.out.println("\nHere is the body: ");

        InputStream input = myRes.body();
        int c;
        while ((c = input.read()) != -1) {
            System.out.print((char)c);
        }

    }
}
