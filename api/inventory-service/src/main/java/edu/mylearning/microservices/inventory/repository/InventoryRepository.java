package edu.mylearning.microservices.inventory.repository;

import edu.mylearning.microservices.inventory.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long> {
    boolean existsByStockUnitCodeAndQuantityIsGreaterThanEqual(String skuCode, Integer quantity);
}
