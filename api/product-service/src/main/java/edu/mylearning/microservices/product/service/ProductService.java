package edu.mylearning.microservices.product.service;

import edu.mylearning.microservices.product.bo.ProductBO;
import edu.mylearning.microservices.product.bo.mapper.ProductBOMapper;
import edu.mylearning.microservices.product.entity.Product;
import edu.mylearning.microservices.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductBOMapper productBOMapper;

    public ProductBO createProduct(ProductBO productBO){
        Product product = productBOMapper.toEntity(productBO);
        Product savedProduct = productRepository.save(product);
        log.info("Product created successfully");
        return productBOMapper.toBO(savedProduct);
    }

    public List<ProductBO> getProducts(){
        List<Product> products = productRepository.findAll();
        return productBOMapper.toBO(products);
    }

}
