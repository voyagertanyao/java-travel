package com.voyager.kylin;

public class DeviceQueryModel {
    private String dt;
    private String province;

    public DeviceQueryModel(String dt, String province) {
        this.dt = dt;
        this.province = province;
    }

    public String getDt() {
        return dt;
    }

    public void setDt(String dt) {
        this.dt = dt;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }
}
