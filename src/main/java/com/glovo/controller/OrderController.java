package com.glovo.controller;

import com.glovo.model.Order;
import com.glovo.model.Product;
import com.glovo.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/glovo")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/order/{orderId}")
    public ResponseEntity<Order> getOrder(@PathVariable("orderId") Integer orderId) {
        Order order = orderService.getOrder(orderId);
        return ResponseEntity.status(HttpStatus.OK).body(order);
    }

    @PostMapping("/order")
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        Order createdOrder = orderService.createOrder(order);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdOrder);
    }

    @PutMapping("/order")
    public ResponseEntity<Order> updateOrder(@RequestBody Order order) {
        Order updateOrder = orderService.updateOrder(order);
        return ResponseEntity.status(HttpStatus.OK).body(updateOrder);
    }

    @PatchMapping("/order/{orderId}/product")
    public ResponseEntity<Order> addProduct(@PathVariable("orderId") Integer orderId, @RequestBody Product product) {
         Order addProductToOrder = orderService.addProductToOrder(orderId, product);
         return ResponseEntity.status(HttpStatus.OK).body(addProductToOrder);

    }

    @DeleteMapping("/order/{orderId}/product/{productId}")
    public ResponseEntity<Order> updateProduct(@PathVariable("orderId") Integer orderId, @PathVariable("productId") Integer productId) {
        Order removeProductFromOrder = orderService.removeProductFromOrder(orderId, productId);
        return ResponseEntity.status(HttpStatus.OK).body(removeProductFromOrder);
    }

    @DeleteMapping("/order/{orderId}")
    public ResponseEntity<Void> deleteOrder(@PathVariable("orderId") Integer orderId) {
        orderService.deleteOrder(orderId);
        return ResponseEntity.noContent().build();
    }

}
