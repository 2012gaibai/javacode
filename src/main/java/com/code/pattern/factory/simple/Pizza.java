package com.code.pattern.factory.simple;

/**
 * 披萨
 * Created by gan on 2016/10/26.
 */
public class Pizza implements IProduct {
    @Override
    public void print() {
        System.out.print("pizza");
    }
}
