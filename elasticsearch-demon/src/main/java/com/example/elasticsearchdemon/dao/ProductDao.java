package com.example.elasticsearchdemon.dao;

import com.example.elasticsearchdemon.bean.Product;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDao extends ElasticsearchRepository<Product, Long> {


    Iterable<Product> search(TermQueryBuilder termQueryBuilder);
}
