package edu.mylearning.microservices.order.bo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderBO {
    private Long id;
    private String orderNumber;
    private String stockUnitCode;
    private BigDecimal price;
    private Integer quantity;
}
