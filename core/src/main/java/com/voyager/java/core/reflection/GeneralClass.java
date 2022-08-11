package com.voyager.java.core.reflection;

import java.lang.reflect.InvocationTargetException;

public class GeneralClass {
    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, ClassNotFoundException {
//        Inner inner = create(Inner.class);
//        System.out.println(inner.sider.init);


        String canonicalName = Integer.class.getCanonicalName();
        Class<?> aClass = Class.forName(canonicalName);
        Object o = aClass.getConstructor(int.class).newInstance(15);
        Integer integer = o instanceof Integer ? ((Integer) o) : null;
        System.out.println(o);
    }

    static <T> T create(Class<T> clazz) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        return clazz.getConstructor().newInstance();
    }
}


class Sider {
    public String init = "";
    public Sider() {
        this.init = "Hello World";
    }
}


class Inner {
    public Sider sider;
    public Inner() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        this.sider = GeneralClass.create(Sider.class);
    }
}
