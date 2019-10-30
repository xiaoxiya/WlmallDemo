package com.xiaoxiya.pizza.domain;

/**
 * @author luopeng
 * @date 2019/10/24 22:54
 */
public class CreditCardPayment extends Payment {
    public CreditCardPayment() {
    }

    private String authorization;
    public void setAuthorization(String authorization) {
        this.authorization = authorization;
    }

    @Override
    public String toString() {
        return "CREDIT:  $" + getAmount() + " ; AUTH: " + authorization;
    }
}
