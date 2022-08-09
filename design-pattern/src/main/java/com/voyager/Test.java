package com.voyager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Integer> l1 = new ArrayList<Integer>();
        l1.add(1);
        l1.add(3);
        l1.add(5);

        List<Integer> l2 = new ArrayList<Integer>();
        l2.add(2);
        l2.add(4);
        l2.add(6);
        l2.add(8);

        System.out.println(Arrays.toString(merge(l1, l2).toArray()));

    }

    public static List<Integer> merge(List<Integer> l1,List<Integer> l2){
        List<Integer> merged = new ArrayList<Integer>(l1.size()+l2.size());

        int j1 = 0;
        int j2 = 0;
        while(j1 < l1.size() && j2 < l2.size()){
            Integer t1 = l1.get(j1);
            Integer t2 = l2.get(j2);
            if(t1 > t2){
                merged.add(t2);
                j2++;
            }else{
                merged.add(t1);
                j1++;
            }
        }
        if(j1 == l1.size() && j2 < l2.size()){
            merged.addAll(l2.subList(j2,l2.size()));
        }else if(j2 == l2.size() && j1 < l1.size()){
            merged.addAll(l1.subList(j1,l1.size()));
        }

        return merged;
    }


    private abstract class Observer {
        Obj obj;
        public void observe(){
            obj.add(this);
        }
        public void receive(){
            System.out.println(obj.get());
        }
    }

    private class Obj {
        private List<Observer> obs = new ArrayList<>();
        private int state;

        public void add(Observer o) {
            obs.add(o);
        }

        public int get(){
            return this.state;
        }

        public void broadcast(){
            obs.forEach(o-> o.receive());
        }
    }
}
