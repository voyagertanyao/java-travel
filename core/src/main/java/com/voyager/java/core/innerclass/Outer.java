package com.voyager.java.core.innerclass;

public class Outer {

    private String out;

    public Outer(String out){
        this.out = out;
    }

    public String outerFunc(){
        return this.out;
    }

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
