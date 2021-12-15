package com.voyager.Decorator;

/**
 * 装饰者模式
 * 1. 抽象接口{@link IFunction}
 * 2. 实现了抽象接口的基本功能类{@link BaseFunc}
 * 3. 实现了抽象接口的基本装饰类{@link BaseDecorator}
 * 4. 继承了基本装饰类的装饰类{@link FunctionPlus},{@link FunctionPlusPlus}
 */
public class Client {
    public static void main(String[] args) {
        IFunction baseFunc = new BaseFunc();

        baseFunc.write("Hello");
        System.out.println(baseFunc.read());

        System.out.println("===============");

        baseFunc = new FunctionPlus(baseFunc);

        baseFunc.write("Hello");
        System.out.println(baseFunc.read());

        System.out.println("===============");

        baseFunc = new FunctionPlusPlus(baseFunc);

        baseFunc.write("Hello");
        System.out.println(baseFunc.read());

    }
}
