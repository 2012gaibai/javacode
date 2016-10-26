package com.code.lambda;

import java.util.List;

/**
 * Created by gan on 2016/1/11.
 */
public class LambdaCode {
    public <T> void threadPrint(T t) {
        new Thread(() -> System.out.println(t)).start();
    }

    public void printAll(){
//        List<>
    }
}
