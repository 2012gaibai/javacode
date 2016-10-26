package com.code.pattern.factory.simple;

/**
 * 简单工厂类
 * Created by gan on 2016/10/26.
 */
public class SimpleFactory {

    public static IProduct createProduct(String type) {
        IProduct product = null;

        if ("pizza".equals(type)) {
            product = new Pizza();
        } else if ("cheese".equals(type)) {
            product = new Cheese();
        }

        return product;


    }

}
