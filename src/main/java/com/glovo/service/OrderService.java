package com.glovo.service;

import com.glovo.model.Order;
import com.glovo.model.Product;

public interface OrderService {
    Order getOrder(int orderId);
    Order createOrder(Order order);
    Order updateOrder(Order order);
    Order addProductToOrder(int orderId, Product product);
    Order removeProductFromOrder(int orderId, int productId);
    void deleteOrder(int orderId);
}
