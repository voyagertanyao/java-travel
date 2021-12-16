package com.voyager.Composite;

public class Leaf implements IComponent{

    private String name;

    public Leaf(String name) {
        this.name = name;
    }

    @Override
    public void operator() {
        System.out.println("Leaf name is " + this.name);
    }
}
