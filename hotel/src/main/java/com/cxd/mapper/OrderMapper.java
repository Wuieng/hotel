package com.cxd.mapper;

import com.cxd.pojo.Order;
import com.sun.org.apache.xpath.internal.operations.Or;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface OrderMapper {

    List<Order> queryOrderList();

    //查询用户拥有的订单
    List<Order> queryOrderListByUserId(int UserId);
    //查询具体的一个订单
    Order queryOrderById(int Id);

    int addOrder(Order order);

    //    下面没有规定要实现可以先不写
    int updateOrder(Order order);

    int deleteOrder(int Id);
}
