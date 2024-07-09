package edu.mylearning.microservices.order.api.exception;

public class NotInStockException extends RuntimeException{

    public NotInStockException(String message){
        super(message);
    }
    public NotInStockException(Exception exception){
        super(exception);
    }
    public NotInStockException(String message, Exception exception){
        super(message, exception);
    }
}
