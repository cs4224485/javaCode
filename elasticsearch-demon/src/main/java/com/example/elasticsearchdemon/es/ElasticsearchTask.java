package com.example.elasticsearchdemon.es;

import org.elasticsearch.client.RestHighLevelClient;

@FunctionalInterface
public interface ElasticsearchTask {

    void doSomething(RestHighLevelClient client) throws Exception;
}
