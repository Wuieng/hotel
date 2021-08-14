package com.cxd.service.serviceimpl;

import com.cxd.mapper.OrderMapper;
import com.cxd.pojo.Hotel;
import com.cxd.pojo.Order;
import com.cxd.pojo.Room;
import com.cxd.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public List<Order> queryOrderList() {
        return orderMapper.queryOrderList();
    }

    @Override
    public List<Order> queryOrderListByUserId(int UserId) {
        return orderMapper.queryOrderListByUserId(UserId);
    }

    @Override
    public Order queryOrderById(int Id) {
        return orderMapper.queryOrderById(Id);
    }

    @Override
    public boolean addOrder(Order order) {
        int i = orderMapper.addOrder(order);
        return 1==i;
    }

    @Override
    public int updateOrder(Order order) {
        return 0;
    }

    @Override
    public int deleteOrder(int Id) {
        return 0;
    }


}
