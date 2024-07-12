package edu.mylearning.microservices.inventory.api.controller.impl;

import edu.mylearning.microservices.inventory.api.controller.InventoryAPIDefinition;
import edu.mylearning.microservices.inventory.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController implements InventoryAPIDefinition {

    private final InventoryService inventoryService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public boolean isInStock(@RequestParam String skuCode, @RequestParam Integer quantity){
        return inventoryService.inStock(skuCode, quantity);
    }
}
