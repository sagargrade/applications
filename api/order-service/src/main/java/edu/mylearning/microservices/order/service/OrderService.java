package edu.mylearning.microservices.order.service;

import edu.mylearning.microservices.order.bo.OrderBO;
import edu.mylearning.microservices.order.bo.mapper.OrderBOMapper;
import edu.mylearning.microservices.order.entity.Order;
import edu.mylearning.microservices.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderBOMapper orderBOMapper;

    public OrderBO placeOrder(OrderBO orderBO){
        Order order = orderBOMapper.toEntity(orderBO);
        Order savedOrder = orderRepository.save(order);
        return orderBOMapper.toBO(savedOrder);
    }
}
