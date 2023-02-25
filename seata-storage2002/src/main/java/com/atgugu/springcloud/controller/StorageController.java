package com.atgugu.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.atgugu.springcloud.service.StorageService;

@RestController
public class StorageController {
    @Autowired
    private StorageService storageService;

    @PostMapping("/storage/decrease")
    public void decreaseStorage(@RequestParam("productId") Long productId,
                                @RequestParam("count") Integer count){
        storageService.decreaseStorage(productId,count);
    }
}
