package com.voyager.java.core.reflection;

import java.lang.reflect.InvocationTargetException;
import java.util.stream.Stream;

public class GeneralClass {
    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, ClassNotFoundException {
//        Inner inner = create(Inner.class);
//        System.out.println(inner.sider.init);


        String canonicalName = Integer.class.getCanonicalName();
        Class<?> aClass = Class.forName(canonicalName);
        Object o = aClass.getConstructor(int.class).newInstance(15);
        Integer integer = o instanceof Integer ? ((Integer) o) : null;
        System.out.println(o);

        // 几乎不使用这种转型方式
        Integer.class.cast(o);


        // error
        Sider sider = (Sider) o;

        // 替换掉 instanceof
        Integer.class.isInstance(o);
        // instanceof需要在右边 写出类对象字面量，难以枚举
        Stream.of(Integer.class, Double.class)
                .filter(Class::isInterface);
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
