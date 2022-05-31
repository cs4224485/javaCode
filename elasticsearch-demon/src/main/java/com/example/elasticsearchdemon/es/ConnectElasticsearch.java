package com.example.elasticsearchdemon.es;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;

public class ConnectElasticsearch {
    public static void connect(ElasticsearchTask task){
        RestHighLevelClient client = new RestHighLevelClient(RestClient.builder(new HttpHost("192.168.31.96", 9200, "http")));
        RestClient.builder(new HttpHost("localhost", 9200, "http"));
        try {
            task.doSomething(client);
            // 关闭客户端连接
            client.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
