package com.voyager.Decorator;

public class FunctionPlus extends BaseDecorator{
    public FunctionPlus(IFunction func) {
        super(func);
    }

    @Override
    public void write(String data) {
        data = "+++" + data + "+++";
        super.write(data);
    }

    @Override
    public String read() {
        return "+++" + super.read() + "+++";
    }
}
