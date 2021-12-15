package com.voyager.Decorator;

public class FunctionPlusPlus extends BaseDecorator{

    public FunctionPlusPlus(IFunction func) {
        super(func);
    }

    @Override
    public void write(String data) {
        data = "---" + data + "---";
        super.write(data);
    }

    @Override
    public String read() {
        return "---" + super.read() + "---";
    }
}
