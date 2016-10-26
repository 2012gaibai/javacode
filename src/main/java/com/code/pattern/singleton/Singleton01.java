package com.code.pattern.singleton;

/**
 * User:甘琪 DateTime: 2016/7/1.
 * <p>
 * 单例模式
 * <p>
 * 1.饿汉式
 * 是否延迟初始化：否
 * 是否多线程安全：是
 * 实现难度：易
 * 优点：没有加锁，执行效率会提高
 * 缺点：类加载时就初始化，浪费内存
 */
public class Singleton01 {
    private Singleton01() {

    }

    private static final Singleton01 instance = new Singleton01();

    public static Singleton01 getInstance() {
        return instance;
    }
}
