package edu.mylearning.microservices.order.bo.mapper;

import edu.mylearning.microservices.order.bo.OrderBO;
import edu.mylearning.microservices.order.entity.Order;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(builder = @Builder(disableBuilder = true), componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface OrderBOMapper {

    OrderBO toBO(Order order);
    List<OrderBO> toBO(List<Order> orders);

    Order toEntity(OrderBO orderBO);
}
