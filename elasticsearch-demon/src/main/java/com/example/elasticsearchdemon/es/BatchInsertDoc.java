package com.example.elasticsearchdemon.es;

import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.common.xcontent.XContentType;

public class BatchInsertDoc {
    public static void main(String[] args) {
        ConnectElasticsearch.connect(client -> {
            // 创建批量新增请求对象
            BulkRequest request = new BulkRequest();
            request.add(new IndexRequest().index("user").id("1001").source(XContentType.JSON, "name", "harry"));
            request.add(new IndexRequest().index("user").id("1002").source(XContentType.JSON, "name", "jerry"));
            request.add(new IndexRequest().index("user").id("1003").source(XContentType.JSON, "name", "sam"));

            // 客户端发送请求 获取响应对象
            BulkResponse response = client.bulk(request, RequestOptions.DEFAULT);
            // 打印结果信息
            System.out.println("took:" + response.getTook());
            System.out.println("items:" + response.getItems());

        });
    }
}
