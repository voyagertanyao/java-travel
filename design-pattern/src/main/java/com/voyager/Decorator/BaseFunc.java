package com.voyager.Decorator;

public class BaseFunc implements IFunction{

    public void write(String data) {
        System.out.println("[BaseFunc.write]:基本写入方法" + data);
    }

    public String read() {
        return "BaseFunc.read()";
    }
}
