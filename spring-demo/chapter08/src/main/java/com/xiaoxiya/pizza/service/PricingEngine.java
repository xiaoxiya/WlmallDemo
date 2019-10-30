package com.xiaoxiya.pizza.service;

import com.xiaoxiya.pizza.domain.Order;

/**
 * @author luopeng
 * @date 2019/10/29 22:41
 */
public interface PricingEngine {
    public float CalculateOrderTotal(Order order);
}
