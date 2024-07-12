package edu.mylearning.microservices.product.api.controller;

import edu.mylearning.microservices.product.bo.ProductBO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@Tag(name = "Product service operations", description = "Provides operation to get and create products")
public interface ProductAPIDefinition {

    @Operation(description = "Get all products")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "All the products are fetched successfully",
                    content = @Content(mediaType = "application/json",
                            array = @ArraySchema(
                                    schema = @Schema(implementation = ProductBO.class)))
            )
    })
    List<ProductBO> getProducts();

    @Operation(description = "Create product")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Product is created successfully",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProductBO.class))
            ),
            @ApiResponse(responseCode = "400", description = "Invalid request")
    })
    ProductBO createProduct(ProductBO productBO);
}
