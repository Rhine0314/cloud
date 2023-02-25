package com.atgugu.springcloud.service.impl;

import com.atgugu.springcloud.dao.StorageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.atgugu.springcloud.service.StorageService;
@Service
public class StorageServiceImpl implements StorageService {
    @Autowired
    private StorageMapper storageMapper;

    @Override
    public int decreaseStorage(Long productId, Integer count) {
        return storageMapper.decreaseStorage(productId, count);
    }
}
