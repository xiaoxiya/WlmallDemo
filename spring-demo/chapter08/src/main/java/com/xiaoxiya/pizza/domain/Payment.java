package com.xiaoxiya.pizza.domain;

import java.io.Serializable;

/**
 * @author luopeng
 * @date 2019/10/21 23:20
 */
public class Payment implements Serializable {
    private static final long serialVersionUID = 1L;

    private float amount;

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }
}
