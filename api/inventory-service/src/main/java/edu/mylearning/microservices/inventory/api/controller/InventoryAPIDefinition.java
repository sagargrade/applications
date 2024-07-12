package edu.mylearning.microservices.inventory.api.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Inventory service operation", description = "Inventory Service API Operation details")
public interface InventoryAPIDefinition {

    @Operation(description = "Check inventory in stock")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Returns true/false depending upon the quantity available")
    })
    boolean isInStock(
            @Parameter(in = ParameterIn.QUERY, name = "skuCode", description = "Stock Unit Code", required = true) String skuCode,
            @Parameter(in = ParameterIn.QUERY, name = "quantity", description = "Requested Quantity of Stock Unit", required = true) Integer quantity);
}
