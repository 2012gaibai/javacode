package com.code.pattern.singleton;

/**
 * User:甘琪 DateTime: 2016/7/1.
 * <p>
 * 单例模式
 * <p>
 * 双检锁
 * <p>
 * 是否延迟初始化：是
 * 是否线程安全：是
 * 实现难度：较复杂
 */
public class Singleton03 {
    private volatile static Singleton03 instance;

    private Singleton03() {

    }

    public static Singleton03 getInstance() {
        if (null == instance) {
            synchronized (Singleton03.class) {
                if (null == instance) {
                    instance = new Singleton03();
                }
            }
        }

        return instance;
    }
}
