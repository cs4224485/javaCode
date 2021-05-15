package com.harry.springcloud.service.impl;

import com.harry.springcloud.dao.StorageDao;
import com.harry.springcloud.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StorageServiceImpl implements StorageService {

    @Autowired
    private StorageDao storageDao;

    @Override
    public void decrease(Long productId, Integer count) {
       storageDao.decrease(productId, count);
    }
}
