package com.xiaoxiya.pizza.service;

import com.xiaoxiya.pizza.domain.Order;
import com.xiaoxiya.pizza.domain.Pizza;
import com.xiaoxiya.pizza.domain.PizzaSize;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @author luopeng
 * @date 2019/10/29 22:42
 */
public class PricingEngineImpl implements PricingEngine, Serializable {

    private static final Logger logger = Logger.getLogger(PricingEngineImpl.class);

    private static Map<PizzaSize, Float> sizePrices;

    static {
        sizePrices = new HashMap<PizzaSize, Float>();
        sizePrices.put(PizzaSize.SMALL, 6.99f);
        sizePrices.put(PizzaSize.MEDIUMM, 7.99f);
        sizePrices.put(PizzaSize.LARGE, 8.99f);
        sizePrices.put(PizzaSize.GINORMOUS, 9.99f);
    }

    private static float PRICE_PER_TOPPING = 0.20f;

    public PricingEngineImpl() {
    }

    @Override
    public float CalculateOrderTotal(Order order) {
        logger.debug("Calculating order total");

        float total = 0.0f;

        for (Pizza pizza : order.getPizzas()) {
            float pizzaPrice = sizePrices.get(pizza.getSize());
            if (pizza.getToppings().size() > 2){
                pizzaPrice += (pizza.getToppings().size() * PRICE_PER_TOPPING);
            }
            total += pizzaPrice;
        }

        return total;
    }
}
