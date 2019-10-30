package com.xiaoxiya.pizza.exception;

/**
 * @author luopeng
 * @date 2019/10/27 21:39
 */
public class CustomerNotFoundException extends Exception {
    public CustomerNotFoundException() {
    }
    public CustomerNotFoundException(String message) {
        super(message);
    }
}
