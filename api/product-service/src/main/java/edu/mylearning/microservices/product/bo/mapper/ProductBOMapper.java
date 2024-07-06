package edu.mylearning.microservices.product.bo.mapper;

import edu.mylearning.microservices.product.bo.ProductBO;
import edu.mylearning.microservices.product.entity.Product;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(builder = @Builder(disableBuilder = true),componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface ProductBOMapper {
    ProductBO toBO(Product product);
    List<ProductBO> toBO(List<Product> products);

    Product toEntity(ProductBO productBO);
}
