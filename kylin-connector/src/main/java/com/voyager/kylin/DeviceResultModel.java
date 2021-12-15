package com.voyager.kylin;

public class DeviceResultModel {
    private String name;
    private Integer nums;
    private Float perc;
    private Float inc_per;
    private Float cur_per;

    @Override
    public String toString() {
        return "DeviceResultModel{" +
                "name='" + name + '\'' +
                ", nums=" + nums +
                ", perc=" + perc +
                ", inc_per=" + inc_per +
                ", cur_per=" + cur_per +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNums() {
        return nums;
    }

    public void setNums(Integer nums) {
        this.nums = nums;
    }

    public Float getPerc() {
        return perc;
    }

    public void setPerc(Float perc) {
        this.perc = perc;
    }

    public Float getInc_per() {
        return inc_per;
    }

    public void setInc_per(Float inc_per) {
        this.inc_per = inc_per;
    }

    public Float getCur_per() {
        return cur_per;
    }

    public void setCur_per(Float cur_per) {
        this.cur_per = cur_per;
    }
}
