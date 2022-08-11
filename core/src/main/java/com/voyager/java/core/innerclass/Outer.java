package com.voyager.java.core.innerclass;

/**
 * 内部类分为；
 * 1. 成员内部类:无条件访问外部类的所有成员属性和成员方法（包括private成员和静态成员）
 *             成员内部类依附于外部类存在，因此必须通过外部类对象创建内部类实例
 * 2. 局部内部类
 * 3. 匿名内部类:不能有访问修饰符和static修饰符，没有构造方法，一般只是用来实现接口方法，不
 *             额外增加方法，适合作为回调、事件驱动类型的场景
 * 4. 静态内部类:static修饰，存在于外部类中，不能访问外部类非static方法和成员，不需要通过外部
 *              实例创建和访问
 */
public class Outer {

    private String out;

    public Outer(String out){
        this.out = out;
    }

    public String outerFunc(){
        return this.out;
    }

    // 成员内部类
    class Inner {
        private final String inner;
        public Inner(String inner) {
            this.inner = inner;
        }

        public String innerFunc(){
            return Outer.this.out + " : " + this.inner;
        }
    }


    interface Interface {
        void fun1();

        void fun2();
    }

    Interface fun(){
        // 匿名内部类
        return new Interface() {
            @Override
            public void fun1() {

            }

            @Override
            public void fun2() {

            }
        }; //分号必须哟
    }


    public static void main(String[] args) {
        Outer outer = new Outer("I'm out class");
        Inner inner = outer.new Inner("I'm inner class");
        System.out.println(inner.innerFunc());
        System.out.println(outer.outerFunc());
    }

}
