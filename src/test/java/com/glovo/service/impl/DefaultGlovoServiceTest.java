package com.glovo.service.impl;

import com.glovo.dao.OrderDao;
import com.glovo.model.Order;
import com.glovo.model.Product;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.List;


@ExtendWith(MockitoExtension.class)
public class DefaultGlovoServiceTest {

    public static List<Product> PRODUCTS;
    public static final int ORDER_ID = 1;
    public static final int PRODUCT_ID = 1;

    @Mock
    private OrderDao orderDao;

    @Mock
    private Order oldOrder;

    @InjectMocks
    private DefaultOrderService orderService;
    private Order order;
    private Product product;


    @BeforeEach
    void setUp() {
        order = new Order(ORDER_ID, LocalDateTime.now(), LocalDateTime.now(), PRODUCTS);
        product = new Product(PRODUCT_ID, "pizza", 12, 2);
    }

    @Test
    void getOrder() {
        orderService.getOrder(ORDER_ID);
        verify(orderDao).getOrder(ORDER_ID);
    }

    @Test
    void addOrder() {
        orderService.createOrder(order);
        verify(orderDao).createOrder(order);
    }

    @Test
    void updateOrder() {
        when(orderDao.getOrder(ORDER_ID)).thenReturn(oldOrder);
        orderService.updateOrder(order);
        verify(orderDao).updateOrder(order);
    }

    @Test
    void addProductToOrder() {
        orderService.addProductToOrder(PRODUCT_ID, product);
        verify(orderDao).addProductToOrder(PRODUCT_ID, product);
    }

    @Test
    void removeProductFromOrder() {
        orderService.removeProductFromOrder(ORDER_ID, PRODUCT_ID);
        verify(orderDao).removeProductFromOrder(ORDER_ID, PRODUCT_ID);

    }

    @Test
    void deleteOrder() {
        orderService.deleteOrder(ORDER_ID);
        verify(orderDao).deleteOrder(ORDER_ID);
    }
}