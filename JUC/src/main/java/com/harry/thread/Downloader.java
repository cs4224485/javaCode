package com.harry.thread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class Downloader {
    public static List<String> download() throws IOException {
        HttpURLConnection urlConnection = (HttpURLConnection)new URL("https://www.baidu.com/").openConnection();
        ArrayList<String> list = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), StandardCharsets.UTF_8))){
            String line;
            while ((line = reader.readLine()) != null){
                list.add(line);
            }
        }
        return list;
    }
}
