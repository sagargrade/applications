package edu.mylearning.microservices.inventory.service;

import edu.mylearning.microservices.inventory.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    public boolean inStock(String skuCode, Integer quantity){
        return inventoryRepository.existsByStockUnitCodeAndQuantityIsGreaterThanEqual(skuCode, quantity);
    }
}
