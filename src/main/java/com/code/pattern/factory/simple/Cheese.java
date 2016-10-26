package com.code.pattern.factory.simple;

/**
 * 芝士
 * Created by gan on 2016/10/26.
 */
public class Cheese implements IProduct {
    @Override
    public void print() {
        System.out.println("cheese");
    }
}
