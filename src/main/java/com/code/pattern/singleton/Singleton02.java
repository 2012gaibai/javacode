package com.code.pattern.singleton;

/**
 * User:甘琪 DateTime: 2016/7/1.
 * <p>
 * 单例模式
 * <p>
 * 1.懒汉式
 * 是否延迟初始化：是
 * 是否多线程安全：是
 * 实现难度：易
 * 描述：具备很好的延迟加载，可以在多线程中很好的工作，但是效率很低，99%情况下不需要同步
 * 优：第一次调用时才加载，避免内存浪费
 * 缺：必须加锁synchronized才能保证单例，影响效率
 */
public class Singleton02 {
    private Singleton02() {

    }

    private static Singleton02 instance = null;

    public static synchronized Singleton02 getInstance() {
        if (null == instance) {
            instance = new Singleton02();
        }
        return instance;
    }
}
