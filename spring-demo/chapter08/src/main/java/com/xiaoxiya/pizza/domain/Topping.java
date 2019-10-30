package com.xiaoxiya.pizza.domain;

import org.apache.commons.lang3.text.WordUtils;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/**
 * @author luopeng
 * @date 2019/10/24 22:39
 */
public enum Topping implements Serializable {
    PEPPERONI,
    SAUSAGE,
    HAMBURGER,
    MUSHROOM,
    CANADIAN_BACON,
    PINEAPPLE,
    GREEN_PEPPER,
    JALAPENO,
    TOMATO,
    ONION,
    EXTRA_CHEESE;

    public static List<Topping> asList() {
        Topping[] all = Topping.values();
        return Arrays.asList(all);
    }


    @Override
    public String toString() {
        return WordUtils.capitalizeFully(name().replace('_',' '));
    }}
