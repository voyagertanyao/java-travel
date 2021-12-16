package com.voyager.Composite;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合模式
 * 1. component 抽象接口
 * 2. leaf 叶子节点（树形结构叶子）
 * 3. composite 中间节点，组合多个component
 */
public class Composite implements IComponent{

    private String name;

    private List<IComponent> items = new ArrayList<IComponent>();

    public Composite(String name) {
        this.name = name;
    }

    public void add(IComponent item) {
        items.add(item);
    }

    @Override
    public void operator() {
        items.forEach(IComponent::operator);
    }
}
