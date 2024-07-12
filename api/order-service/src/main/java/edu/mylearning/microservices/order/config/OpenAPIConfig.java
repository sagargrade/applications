package edu.mylearning.microservices.order.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI orderServiceOpenApi(){
        return new OpenAPI()
                .info(new Info()
                        .title("Order Service API")
                        .description("Order Service API Operation Details")
                        .version("0.0.1"))
                .externalDocs(new ExternalDocumentation()
                        .description("Please refer to Order Service Wiki")
                        .url("http://localhost:8081/api-docs"));
    }
}
