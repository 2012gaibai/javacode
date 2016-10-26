package com.code.reflect;

/**
 * User:甘琪 DateTime: 2016/7/1.
 */
public class ClassDemo1 {

    public static void main(String[] args) {
        Foo foo1 = new Foo();

        Class c1 = Foo.class;

        Class c2 = foo1.getClass();

        System.out.println(c1 == c2);

        Class c3 = null;
        try {
            c3 = Class.forName("com.code.reflect.Foo");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println(c2 == c3);

        try {
            Foo foo = (Foo) c2.newInstance();
            foo.print();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}

class Foo {
    void print() {
        System.out.println("Foo");
    }
}