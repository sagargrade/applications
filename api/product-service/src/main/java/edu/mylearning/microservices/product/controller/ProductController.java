package edu.mylearning.microservices.product.controller;

import edu.mylearning.microservices.product.bo.ProductBO;
import edu.mylearning.microservices.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductBO createProduct(@RequestBody ProductBO productBO){
        return productService.createProduct(productBO);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductBO> getProducts(){
        return productService.getProducts();
    }
}
