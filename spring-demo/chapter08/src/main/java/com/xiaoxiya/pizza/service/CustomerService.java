package com.xiaoxiya.pizza.service;

import com.xiaoxiya.pizza.domain.Customer;
import com.xiaoxiya.pizza.exception.CustomerNotFoundException;

/**
 * @author luopeng
 * @date 2019/10/29 22:26
 */
public interface CustomerService {
    Customer lookupCustomer(String phoneNumber) throws CustomerNotFoundException;
}
