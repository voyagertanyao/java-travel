package com.voyager.kylin;

public class DeviceQueryModel {
    private String dt;
//    private List<String> province;

    public DeviceQueryModel(String dt) {
        this.dt = dt;
//        this.province = province;
    }

    public String getDt() {
        return dt;
    }

    public void setDt(String dt) {
        this.dt = dt;
    }

//    public List<String> getProvince() {
//        return province;
//    }

//    public void setProvince(List<String> province) {
//        this.province = province;
//    }
}
