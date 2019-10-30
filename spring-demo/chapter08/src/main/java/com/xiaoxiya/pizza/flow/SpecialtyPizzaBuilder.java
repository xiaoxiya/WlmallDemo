package com.xiaoxiya.pizza.flow;

import com.xiaoxiya.pizza.domain.Pizza;
import com.xiaoxiya.pizza.domain.Topping;
import org.apache.log4j.Logger;
import org.springframework.webflow.execution.Action;
import org.springframework.webflow.execution.Event;
import org.springframework.webflow.execution.RequestContext;

import java.util.ArrayList;
import java.util.List;

/**
 * @author luopeng
 * @date 2019/10/30 22:15
 */
public class SpecialtyPizzaBuilder implements Action {

    private static final Logger logger = Logger.getLogger(SpecialtyPizzaBuilder.class);

    @Override
    public Event execute(RequestContext requestContext) throws Exception {
        String type = requestContext.getRequestParameters().get("pizzaType");
        logger.debug("BUILDING A SPECIALTY PIZZA:  " + type);

        Pizza pizza = (Pizza) requestContext.getFlowScope().get("pizza");
        if ("MEAT ".equals(type)) {
            logger.debug("BUILDING A CARNIVORE");
            List<Topping> meats = new ArrayList<Topping>();

            meats.add(Topping.CANADIAN_BACON);
            meats.add(Topping.HAMBURGER);
            meats.add(Topping.PEPPERONI);
            meats.add(Topping.SAUSAGE);

            pizza.setToppings(meats);
        } else if ("VEGGIE".equals(type)) {
            logger.debug("BUILDING A HERBIVORE");

            List<Topping> meats = new ArrayList<>();

            meats.add(Topping.GREEN_PEPPER);
            meats.add(Topping.MUSHROOM);
            meats.add(Topping.PINEAPPLE);
            meats.add(Topping.TOMATO);

            pizza.setToppings(meats);
        } else if ("THEWORKS".equals(type)) {
            logger.debug("BUILDING AN OMNIVORE");

            List<Topping> meats = new ArrayList<>();

            System.out.println("THE WORKS!");

            meats.add(Topping.CANADIAN_BACON);
            meats.add(Topping.HAMBURGER);
            meats.add(Topping.PEPPERONI);
            meats.add(Topping.SAUSAGE);
            meats.add(Topping.GREEN_PEPPER);
            meats.add(Topping.MUSHROOM);
            meats.add(Topping.PINEAPPLE);
            meats.add(Topping.TOMATO);
            meats.add(Topping.EXTRA_CHEESE);
            meats.add(Topping.ONION);
            meats.add(Topping.JALAPENO);

            pizza.setToppings(meats);
        }
        requestContext.getFlashScope().put("pizza", pizza);

        return new Event(this, "success");
    }
}
