package edu.mylearning.microservices.inventory.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI inventoryServiceOpenApi(){
        return new OpenAPI()
                .info(new Info()
                        .title("Inventory Service API")
                        .description("Inventory Service API Operation Details")
                        .version("0.0.1"))
                .externalDocs(new ExternalDocumentation()
                        .description("Please refer to Inventory Service Wiki")
                        .url("http://localhost:8082/api-docs"));
    }
}
