package edu.mylearning.microservices.order.api.controller.impl;

import edu.mylearning.microservices.order.api.controller.OrderAPIDefinition;
import edu.mylearning.microservices.order.bo.OrderBO;
import edu.mylearning.microservices.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/orders")
public class OrderController implements OrderAPIDefinition {

    private final OrderService orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrderBO placeOrder(@RequestBody OrderBO orderBO){
        return orderService.placeOrder(orderBO);
    }
}
