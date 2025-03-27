package com.glovo.dao;

import com.glovo.model.Order;
import com.glovo.model.Product;


public interface OrderDao {
    Order getOrder(int orderId);
    void createOrder(Order order);
    void updateOrder(Order order);
    void addProductToOrder(int orderId, Product product);
    void removeProductFromOrder(int orderId, int productId);
    void deleteOrder(int orderId);
}
