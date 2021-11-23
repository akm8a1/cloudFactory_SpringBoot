package com.liu.service;

import com.liu.mapper.OrderMapper;
import com.liu.pojo.EquipmentInfo;
import com.liu.pojo.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 订单Service实现类
 */
@Service
public class OrderServiceImpl implements OrderService{
    @Autowired
    private OrderMapper mapper;
    @Override
    public List<Order> queryAllOrders() {
        return mapper.queryAllOrders();
    }

    @Override
    public List<Order> queryOrderByNo(String no) {
        return mapper.queryOrderByNo(no);
    }

    @Override
    public int addOrder(Order order) {
        return mapper.addOrder(order);
    }

    @Override
    public int updateOrder(Order order) {
        return mapper.updateOrder(order);
    }

    @Override
    public int deleteOrder(String id) {
        return mapper.deleteOrder(id);
    }

    @Override
    public List<Order> queryFactoryOrdersByUserId(String id) {
        return mapper.queryFactoryOrdersByUserId(id);
    }

    @Override
    public List<Order> queryTraderOrdersByUserId(String id) {
        return mapper.queryTraderOrdersByUserId(id);
    }

    @Override
    public List<Order> queryOrdersBidable(String id) {
        return mapper.queryOrdersBidable(id);
    }

    @Override
    public int updateStatus(String id, int status) {
        return mapper.updateStatus(id,status);
    }

    @Override
    public int bidComplete(String factoryid, String orderid) {
        return mapper.bidComplete(factoryid,orderid);
    }

    @Override
    public int getCounts() {
        return mapper.getCounts();
    }

    @Override
    public Order queryOrderById(String id) {
        return mapper.queryOrderById(id);
    }

}
