package edu.mylearning.microservices.order;

import edu.mylearning.microservices.order.stub.InventoryClientStub;
import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.testcontainers.containers.MySQLContainer;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWireMock(port = 0)
class OrderServiceApplicationTests {

    @ServiceConnection
    static final MySQLContainer MY_SQL_CONTAINER;
    @LocalServerPort
    private Integer port;

    static {
        MY_SQL_CONTAINER = new MySQLContainer("mysql:8.3.0");
        MY_SQL_CONTAINER.start();
    }

    @BeforeEach
    void setUp(){
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = port;
    }

    @Test
    void shouldPlaceOrder() {
        String requestBody = """
                {
                    "stockUnitCode" : "Lava_Z6",
                    "price": 10000,
                    "quantity" : 1
                }
                """;
        InventoryClientStub.stubInventoryCall("Lava_Z6", 1);
        RestAssured.given()
                .contentType("application/json")
                .body(requestBody)
                .when()
                .post("/api/orders")
                .then()
                .statusCode(201)
                .body("id", Matchers.notNullValue())
                .body("stockUnitCode", Matchers.equalTo("Lava_Z6"))
                .body("price",Matchers.equalTo(10000));
    }
}
