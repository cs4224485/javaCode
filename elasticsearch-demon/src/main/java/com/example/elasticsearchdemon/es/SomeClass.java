package com.example.elasticsearchdemon.es;

public class SomeClass {
    public static void main(String[] args) {
        ConnectElasticsearch.connect(client -> {
            //do something
            System.out.println(client);
        });

    }
}
