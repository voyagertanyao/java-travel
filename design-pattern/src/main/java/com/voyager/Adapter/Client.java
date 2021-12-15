package com.voyager.Adapter;

/**
 * 适配器模式
 * 1. 客户端对象{@link com.voyager.Adapter.Client}
 * 2. 客户端调用方法{@link IFunction}
 * 3. 适配器实现客户端调用方法{@link com.voyager.Adapter.Wrapper}
 * 4. 适配器封装调用方法的实现类{@link com.voyager.Adapter.Service}
 */
public class Client {
    public static void main(String[] args) {
        Wrapper wrapper = new Wrapper(new Service());
        System.out.println(wrapper.get());
    }
}
