package com.code.lambda;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by gan on 2016/1/11.
 */
public class LambdaCodeTest {

    @Test
    public void testThreadPrint() throws Exception {
       new LambdaCode().threadPrint("sqd");
    }
}