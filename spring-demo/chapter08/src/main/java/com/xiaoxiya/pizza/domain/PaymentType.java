package com.xiaoxiya.pizza.domain;

import org.apache.commons.lang3.text.WordUtils;

import java.util.Arrays;
import java.util.List;

/**
 * @author luopeng
 * @date 2019/10/24 22:51
 */
public enum  PaymentType {
    CASH, CHECK, CREDIT_CARD;

    public static List<PaymentType> asList() {
        PaymentType[] all = PaymentType.values();
        return Arrays.asList(all);
    }


    @Override
    public String toString() {
        return WordUtils.capitalizeFully(name().replace('_', ' '));
    }}
