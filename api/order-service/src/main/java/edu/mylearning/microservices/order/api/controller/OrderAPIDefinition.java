package edu.mylearning.microservices.order.api.controller;

import edu.mylearning.microservices.order.bo.OrderBO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Order service operations", description = "Provides operation to place order")
public interface OrderAPIDefinition {
    @Operation(description = "Place order")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Order is successfully placed",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = OrderBO.class))
            ),
            @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    OrderBO placeOrder(OrderBO orderBO);
}
