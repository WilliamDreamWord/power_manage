package com.wewin.power_manage.service;

import com.wewin.power_manage.entity.Device;
import com.wewin.power_manage.eto.DeviceEto;

import java.util.List;

/**
 * @Author: William
 * @Description:service/Device
 * @Date: 2018/10/24 09:23
 **/
public interface DeviceService {

    int addDevice(Device device);

    List<Object> deleteDevice(List<String> deviceID);

    int updateDevice(Device device);

    List<DeviceEto> selectAll();

    DeviceEto selectDevice(String device_id);
}
