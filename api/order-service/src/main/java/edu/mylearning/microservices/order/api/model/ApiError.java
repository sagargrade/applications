package edu.mylearning.microservices.order.api.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@Builder
public class ApiError {
    private HttpStatus status;
    private String message;
    private String errorCode;
}
