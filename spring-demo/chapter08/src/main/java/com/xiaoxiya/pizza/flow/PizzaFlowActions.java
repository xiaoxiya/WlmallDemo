package com.xiaoxiya.pizza.flow;


import com.xiaoxiya.pizza.domain.*;
import com.xiaoxiya.pizza.exception.CustomerNotFoundException;
import com.xiaoxiya.pizza.service.CustomerService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author luopeng
 * @date 2019/10/27 21:36
 */
@Component
public class PizzaFlowActions {
    private static final Logger logger = Logger.getLogger(PizzaFlowActions.class);

    @Autowired
    CustomerService customerService;

    public void addCustomer(Customer customer) {
        logger.warn("TODO:Flesh out the addCustomer() method.");
    }

    public void saveOrder(Order order) {
        logger.warn("TODO: Flesh out the saveOrder() method.");
    }

    public boolean checkDeliverArea(String zipCode) {
        logger.warn("TODO:Flesh out the checkDeliveryArea() method.");
        return "75075".equals(zipCode);
    }

    public Customer lookupCustomer(String phoneNumber) throws CustomerNotFoundException {
        Customer customer = customerService.lookupCustomer(phoneNumber);
        if (customer != null) {
            return customer;
        } else {
            throw new CustomerNotFoundException();
        }
    }

    public Payment verifyPayment(PaymentDetails paymentDetails) {
        Payment payment = null;
        if (paymentDetails.getPaymentType() == PaymentType.CREDIT_CARD) {
            payment = new CreditCardPayment();
        } else {
            payment = new CashOrCheckPayment();
        }
        return payment;
    }

}
