package edu.mylearning.microservices.product.bo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ProductBO {
    private String id;
    private String name;
    private String description;
    private BigDecimal price;
}
