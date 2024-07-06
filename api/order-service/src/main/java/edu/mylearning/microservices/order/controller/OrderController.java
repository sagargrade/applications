package edu.mylearning.microservices.order.controller;

import edu.mylearning.microservices.order.bo.OrderBO;
import edu.mylearning.microservices.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrderBO placeOrder(@RequestBody OrderBO orderBO){
        return orderService.placeOrder(orderBO);
    }
}
