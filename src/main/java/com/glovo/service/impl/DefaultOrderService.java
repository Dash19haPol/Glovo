package com.glovo.service.impl;

import com.glovo.dao.OrderDao;
import com.glovo.model.Order;
import com.glovo.model.Product;
import com.glovo.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class DefaultOrderService implements OrderService {

    private final OrderDao orderDao;

    @Override
    public Order getOrder(int orderId) {
       return orderDao.getOrder(orderId);
    }

    @Override
    public Order createOrder(Order order) {
        LocalDateTime now = LocalDateTime.now();
        order.setCreateDate(now);
        order.setUpdateDate(now);
        orderDao.createOrder(order);
        return order;
    }

    @Override
    public Order updateOrder(Order newOrder) {
        Order oldOrder = orderDao.getOrder(newOrder.getOrderId());
        newOrder.setCreateDate(oldOrder.getCreateDate());
        newOrder.setUpdateDate(LocalDateTime.now());
        orderDao.updateOrder(newOrder);
        return newOrder;
    }

    @Override
    public Order addProductToOrder(int orderId, Product product) {
        orderDao.addProductToOrder(orderId, product);
        return orderDao.getOrder(orderId);
    }

    @Override
    public Order removeProductFromOrder(int orderId, int productId) {
        orderDao.removeProductFromOrder(orderId, productId);
        return orderDao.getOrder(orderId);
    }

    @Override
    public void deleteOrder(int orderId) {
        orderDao.deleteOrder(orderId);

    }
}
