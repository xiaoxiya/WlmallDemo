package com.xiaoxiya.pizza.service;

import com.xiaoxiya.pizza.exception.PaymentException;
import org.springframework.stereotype.Service;

/**
 * @author luopeng
 * @date 2019/10/29 22:39
 */
public class PaymentProcessor {
    public PaymentProcessor() {
    }

    public void approveCreditCard(String creditCardNumber, String expMonth,
                                  String expYear, float amount) throws PaymentException {
        if (amount > 20.00) {
            throw new PaymentException();
        }
    }
}
