package com.voyager.Decorator;

/**
 * 基础装饰器：实现 + 集成 同一个抽象接口
 */
public class BaseDecorator implements IFunction{

    private IFunction func;

    public BaseDecorator(IFunction func) {
        this.func = func;
    }

    public void write(String data) {
        func.write(data);
    }

    public String read() {
        return func.read();
    }
}
