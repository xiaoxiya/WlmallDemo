package com.xiaoxiya.pizza.domain;

import java.io.Serializable;

/**
 * @author luopeng
 * @date 2019/10/24 22:50
 */
public class PaymentDetails implements Serializable {
    private static final long serialVersionUID = 1L;

    private PaymentType paymentType;
    private String creditCardNumber;

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }
}
