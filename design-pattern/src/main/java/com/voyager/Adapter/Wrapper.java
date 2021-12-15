package com.voyager.Adapter;

/**
 * 适配器模式
 *
 */
public class Wrapper implements IFunction {

    private Service service;

    public Wrapper(Service service) {
        this.service = service;
    }

    public String get() {
        return String.valueOf(service.is_true());
    }
}
