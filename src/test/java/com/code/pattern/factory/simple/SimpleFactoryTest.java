package com.code.pattern.factory.simple;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by gan on 2016/10/26.
 */
public class SimpleFactoryTest {
    @Test
    public void testSimple() {
        SimpleFactory.createProduct("pizza").print();
    }
}