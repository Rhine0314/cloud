package com.atgugu.springcloud.dao;

import com.atgugu.springcloud.entity.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface OrderMapper {

    //创建订单
    int createOrder(Order order);

    //修改订单状态
    int updateOrderStatus(@Param("userId") Long userId,
                          @Param("productId") Long productId,
                          @Param("status") Integer status);
}
