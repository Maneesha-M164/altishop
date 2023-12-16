package com.altimetrik.altishop.exception;

public class ProductIdNotExistException extends Exception{
    String msg;
    public ProductIdNotExistException(){
        super();
    }
    public ProductIdNotExistException(String msg) {
        super(msg);
        this.msg = msg;
    }
}
