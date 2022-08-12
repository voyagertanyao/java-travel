package com.voyager.java.core.reflection;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyProxy {




    public static void main(String[] args) {
        DefaultHandler defaultHandler = new DefaultHandler();
        Handler handlerProxy = (Handler)Proxy.newProxyInstance(defaultHandler.getClass().getClassLoader(),
                new Class[]{Handler.class},
                new ProxyHandler(defaultHandler));

        handlerProxy.handle();


    }

}


interface Handler {
    void handle();
}

class ProxyHandler implements InvocationHandler {

    private Object object;

    public ProxyHandler(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Invoke Method Before");
        return method.invoke(object, args);
    }
}

class DefaultHandler implements Handler {
    @Override
    public void handle() {
        System.out.println("Hello World");
    }
}
