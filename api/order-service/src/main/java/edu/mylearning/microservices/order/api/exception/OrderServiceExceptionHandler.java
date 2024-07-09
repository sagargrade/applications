package edu.mylearning.microservices.order.api.exception;

import edu.mylearning.microservices.order.api.model.ApiError;
import edu.mylearning.microservices.order.api.model.ErrorCode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class OrderServiceExceptionHandler {

    @ExceptionHandler(value = {NotInStockException.class})
    public ResponseEntity<ApiError> handleNotInStockException(NotInStockException notInStockException){
        ApiError apiError = ApiError.builder()
                .status(HttpStatus.NOT_FOUND)
                .message(notInStockException.getMessage())
                .errorCode(ErrorCode.NOT_IN_STOCK_ERROR)
                .build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiError);
    }
}
