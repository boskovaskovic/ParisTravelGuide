package com.bvinstruments.paristravelguide.handlers;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpHandler {


    private  URL url;




    public String getData() throws MalformedURLException, IOException {

       url = new URL("https://newsapi.org/v2/everything?q=paris&from=2018-12-27&sortBy=publishedAt&apiKey=968491bb00f3402e8315a2099ba56ac3");
        HttpURLConnection con=(HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        BufferedReader in=new BufferedReader(new InputStreamReader(con.getInputStream()));
        return readData(in);




    }

    private String readData(BufferedReader in) throws IOException{

        StringBuilder builder=new StringBuilder();
        String line="";
        while((line=in.readLine())!=null){
         builder.append(line);


        }
        in.close();
return builder.toString();

    }






}
