package com.xiaoxiya.pizza.domain;

/**
 * @author luopeng
 * @date 2019/10/24 22:56
 */
public class CashOrCheckPayment extends Payment {
    public CashOrCheckPayment() {
    }

    @Override
    public String toString() {
        return "CASH or CHECK:  $" + getAmount();
    }
}
