package io.github.wildcraft.restclient.api;

import io.github.wildcraft.restclient.model.Response;
import org.apache.commons.io.IOUtils;
import org.apache.http.*;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicHeader;

import java.io.IOException;
import java.io.StringWriter;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by NAS on 9/7/2017
 */
public class RestClient {

    private static final RestClient CLIENT = new RestClient();
    private HttpClient client = null;

    private RestClient(){
        initHttpClient();
    }

    private void initHttpClient() {
        client = HttpClientBuilder.create().build();
    }

    public RestClient get(){
        return CLIENT;
    }

    public Response get(String host, Map<String,String> headers){

        HttpRequest request = new HttpGet();

        HttpHost httpHost = new HttpHost(host);

        List<BasicHeader> collect = headers.entrySet()
                .stream()
                .map(entry -> new BasicHeader(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());

        Header[] headrs = (Header[]) collect.toArray();
        request.setHeaders(headrs);

        try {
            HttpResponse execute = client.execute(httpHost, request);
            StringWriter writer = new StringWriter();
            IOUtils.copy(execute.getEntity().getContent(),writer);
            return new Response(writer.toString(),execute.getStatusLine().getStatusCode());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new Response("Request Failed",500);
    }

}
