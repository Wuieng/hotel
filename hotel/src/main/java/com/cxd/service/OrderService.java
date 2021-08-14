package com.cxd.service;

import com.cxd.pojo.Hotel;
import com.cxd.pojo.Order;
import com.cxd.pojo.Room;


import java.util.List;

public interface OrderService {

    List<Order> queryOrderList();

    //查询用户拥有的订单
    List<Order> queryOrderListByUserId(int UserId);
    //查询具体的一个订单
    Order queryOrderById(int Id);

    boolean addOrder(Order order);

    //    下面没有规定要实现可以先不写
    int updateOrder(Order order);

    int deleteOrder(int Id);


}
