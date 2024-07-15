package edu.mylearning.microservices.order.client;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;

//@FeignClient(value = "inventory", url = "${application.inventory.service.url}")
public interface InventoryClient {

    static final Logger log = LoggerFactory.getLogger(InventoryClient.class);

    //    @GetMapping(value = "/api/inventory")
    @GetExchange(value = "/api/inventory")
    @CircuitBreaker(name = "inventory", fallbackMethod = "fallbackMethod")
    @Retry(name = "inventory")
    boolean isInStock(@RequestParam String skuCode, @RequestParam Integer quantity);

    default boolean fallbackMethod(String code, Integer quantity, Throwable throwable) {
        log.info("Can not get inventory for sku code {} failure reason : {}", code, throwable.getMessage());
        return false;
    }
}
