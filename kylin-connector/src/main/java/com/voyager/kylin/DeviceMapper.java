package com.voyager.kylin;

import java.util.List;

public interface DeviceMapper {

    List<DeviceResultModel> deviceSending(DeviceQueryModel model);
}
