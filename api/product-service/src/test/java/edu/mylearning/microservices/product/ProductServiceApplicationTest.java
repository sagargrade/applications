package edu.mylearning.microservices.product;

import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.testcontainers.containers.MongoDBContainer;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductServiceApplicationTest {

    @ServiceConnection  //Spring Boot will automatically add uri for mango db
    static MongoDBContainer mongoDBContainer = new MongoDBContainer("mongo:7.0.5");

    @LocalServerPort    //Inject the port on which test is running
    private Integer port;

    @BeforeEach
    void setUp(){
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = port;
    }

    static {
        mongoDBContainer.start(); // Start test container
    }

    @Test
    void shouldCreateProduct(){
        String requestBody = """
                {
                    "name": "Lava Z4",
                    "description": "Lava Z4 smartphone from Lava",
                    "price": 8000
                }
                """;
        RestAssured.given()
                .contentType("application/json")
                .body(requestBody)
                .when()
                .post("/api/products")
                .then()
                .statusCode(201)
                .body("id", Matchers.notNullValue())
                .body("name", Matchers.equalTo("Lava Z4"))
                .body("description", Matchers.equalTo("Lava Z4 smartphone from Lava"))
                .body("price", Matchers.equalTo(8000));
    }
}