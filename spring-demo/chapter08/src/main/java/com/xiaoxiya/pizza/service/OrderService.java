package com.xiaoxiya.pizza.service;

import com.xiaoxiya.pizza.domain.Order;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

/**
 * @author luopeng
 * @date 2019/10/29 22:31
 */
public class OrderService {
    private static final Logger logger = Logger.getLogger(OrderService.class);

    public OrderService() {
    }

    public void saveOrder(Order order) {
        logger.debug("SAVING ORDER:  " );
        logger.debug("   Customer:  " + order.getCustomer().getName());
        logger.debug("   # of Pizzas:  " + order.getPizzas().size());
        logger.debug("   Payment:  " + order.getPayment());
    }
}
