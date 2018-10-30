package com.wewin.power_manage.eto;

import com.wewin.power_manage.entity.Device;
import com.wewin.power_manage.entity.Device_model;
import com.wewin.power_manage.entity.Part_model;
import com.wewin.power_manage.entity.Prof_model;
import org.springframework.stereotype.Repository;

/**
 * @Author: William
 * @Description: eto/对业务逻辑的解耦，返回数据的杂糅
 * @Date: 2018/10/23 18:00
 **/
@Repository
public class DeviceEto {

    private Device device;

    private Device_model deviceModel;

    private Prof_model profModel;

    private Part_model partModel;

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    public Device_model getDeviceModel() {
        return deviceModel;
    }

    public void setDeviceModel(Device_model deviceModel) {
        this.deviceModel = deviceModel;
    }

    public Prof_model getProfModel() {
        return profModel;
    }

    public void setProfModel(Prof_model profModel) {
        this.profModel = profModel;
    }

    public Part_model getPartModel() {
        return partModel;
    }

    public void setPartModel(Part_model partModel) {
        this.partModel = partModel;
    }
}