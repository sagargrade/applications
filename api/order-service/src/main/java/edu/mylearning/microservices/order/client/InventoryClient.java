package edu.mylearning.microservices.order.client;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;

//@FeignClient(value = "inventory", url = "${application.inventory.service.url}")
public interface InventoryClient {

//    @GetMapping(value = "/api/inventory")
    @GetExchange(value = "/api/inventory")
    boolean isInStock(@RequestParam String skuCode, @RequestParam Integer quantity);
}
