package com.atgugu.springcloud.service;

public interface StorageService {

    int decreaseStorage(Long productId, Integer count);
}
