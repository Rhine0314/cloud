package com.atgugu.springcloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface StorageMapper {
    int decreaseStorage(@Param("productId") Long productId, @Param("count") Integer count);
}
