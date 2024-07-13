package edu.mylearning.microservices.order.service;

import edu.mylearning.microservices.order.bo.OrderBO;
import edu.mylearning.microservices.order.bo.mapper.OrderBOMapper;
import edu.mylearning.microservices.order.client.InventoryClient;
import edu.mylearning.microservices.order.entity.Order;
import edu.mylearning.microservices.order.api.exception.NotInStockException;
import edu.mylearning.microservices.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderBOMapper orderBOMapper;
    private final InventoryClient inventoryClient;

    public OrderBO placeOrder(OrderBO orderBO){
        if (inventoryClient.isInStock(orderBO.getStockUnitCode(), orderBO.getQuantity())){
            Order order = orderBOMapper.toEntity(orderBO);
            order.setOrderNumber(UUID.randomUUID().toString());
            order.setPrice(order.getPrice().multiply(BigDecimal.valueOf(order.getQuantity())));
            Order savedOrder = orderRepository.save(order);
            return orderBOMapper.toBO(savedOrder);
        } else {
            throw new NotInStockException("Stock unit code " + orderBO.getStockUnitCode() + " not in stock.!!!");
        }
    }
}
