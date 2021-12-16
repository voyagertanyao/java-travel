package com.voyager.Composite;

public class Client {

    public static void main(String[] args) {
        Composite root = new Composite("总包");

        Leaf l1 = new Leaf("叶子1");
        Leaf l2 = new Leaf("叶子2");

        root.add(l1);
        root.add(l2);

        Composite mid = new Composite("分包");

        Leaf l3 = new Leaf("叶子3");

        mid.add(l3);

        root.add(mid);

        root.operator();
    }


}
