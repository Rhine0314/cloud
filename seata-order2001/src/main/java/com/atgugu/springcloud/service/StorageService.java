package com.atgugu.springcloud.service;

import com.atgugu.springcloud.entity.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("seata-storage-service")
public interface StorageService {
    //根据产品和数量，减去对应的产品的库存
    @PostMapping("/storage/decrease")
    void decreaseStorage(@RequestParam("productId") Long productId, @RequestParam("count") Integer count);
}
