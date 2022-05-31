package com.example.elasticsearchdemon.es;

import com.example.elasticsearchdemon.bean.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.common.xcontent.XContentType;

public class InsertDoc {

    public static void main(String[] args) {
        ConnectElasticsearch.connect(client -> {
            // 新增文档 - 请求对象
            IndexRequest request = new IndexRequest();
            // 设置索引及唯一性标识
            request.index("user").id("1001");

            User user = new User();
            user.setName("zhangsan");
            user.setAge(30);
            user.setSex("男");

            ObjectMapper mapper = new ObjectMapper();
            String productJson = mapper.writeValueAsString(user);
            // 添加文档数据 数据格式为 JSON 格式
            IndexRequest source = request.source(productJson, XContentType.JSON);
            // 客户端发送请求， 获取响应对象
            IndexResponse response = client.index(request, RequestOptions.DEFAULT);

            System.out.println("_index:" + response.getIndex());
            System.out.println("_id:" + response.getId());
            System.out.println("_result:" + response.getResult());


        });
    }
}
