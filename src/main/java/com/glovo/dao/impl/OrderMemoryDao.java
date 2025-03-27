package com.glovo.dao.impl;
import com.glovo.dao.OrderDao;
import com.glovo.model.Order;
import com.glovo.model.Product;
import org.springframework.stereotype.Component;

import java.util.HashMap;

import java.util.Map;

@Component
public class OrderMemoryDao implements OrderDao {
    private final Map<Integer, Order> orders = new HashMap<>();

    @Override
    public Order getOrder(int orderId) {
        return orders.get(orderId);
    }

    @Override
    public void createOrder(Order order) {
        orders.put(order.getOrderId(), order);
    }

    @Override
    public void updateOrder(Order order) {
        orders.put(order.getOrderId(), order);
    }

    @Override
    public void addProductToOrder(int orderId, Product product) {
        Order order = orders.get(orderId);
        order.getProducts().add(product);
    }

    @Override
    public void removeProductFromOrder(int orderId, int productId) {
        Order order = orders.get(orderId);
        Product product = order.getProducts().get(productId - 1);
        order.getProducts().remove(product);
    }

    @Override
    public void deleteOrder(int orderId) {
        orders.remove(orderId);
    }
}
