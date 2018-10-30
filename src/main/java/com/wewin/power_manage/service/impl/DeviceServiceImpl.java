package com.wewin.power_manage.service.impl;

import com.wewin.power_manage.dao.DeviceMapper;
import com.wewin.power_manage.dao.Device_modelMapper;
import com.wewin.power_manage.dao.Part_modelMapper;
import com.wewin.power_manage.dao.Prof_modelMapper;
import com.wewin.power_manage.entity.Device;
import com.wewin.power_manage.eto.DeviceEto;
import com.wewin.power_manage.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: William
 * @Description:serviceImpl/device
 * @Date: 2018/10/24 09:32
 **/
@Transactional(rollbackFor = {Exception.class})
@Service
public class DeviceServiceImpl implements DeviceService {

    @SuppressWarnings("all")
    @Autowired
    private DeviceMapper deviceMapper;

    @SuppressWarnings("all")
    @Autowired
    private Device_modelMapper device_modelMapper;

    @SuppressWarnings("all")
    @Autowired
    private Prof_modelMapper prof_modelMapper;

    @SuppressWarnings("all")
    @Autowired
    private Part_modelMapper part_modelMapper;

    @SuppressWarnings("all")
    @Autowired
    private DeviceEto deviceEto;


    /**
     *
     * 增加设备
     * @param device
     * @return:int
     */
    @Override
    public int addDevice(Device device) {

        try {
            return deviceMapper.insert(device);
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return -1;
        }

    }

    /**
     *
     * 批量删除设备并检索出删除出错的设备
     * @param deviceID
     * @return List
     */
    @Override
    public List<Object> deleteDevice(List<String> deviceID) {

        List<Object> list = new ArrayList<>();

        try {
            for (String s : deviceID) {
                if (deviceMapper.deleteByID(s) == 0) {
                    list.add(s);
                }
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return null;
        }finally {
            System.out.println("delete device error!");
        }

    }

    /**
     *
     * 更新设备信息
     * @param device
     * @return int
     *
     */
    @Override
    public int updateDevice(Device device) {

        try {
            return deviceMapper.updateByPrimaryKeyWithBLOBs(device);
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return -1;
        }
    }

    /**
     *
     * 查询所有的设备信息
     * @return 耦合DeviceEto
     */
    @Override
    public List<DeviceEto> selectAll() {

        List<DeviceEto> deviceEtos = new ArrayList<>();

        List<Device> devices = deviceMapper.selectAll();

        for (Device o : devices) {
            deviceEto.setDevice(o);
            deviceEto.setDeviceModel(device_modelMapper.selectByID(o.getDeviceModel()));
            deviceEto.setProfModel(prof_modelMapper.selectByID(o.getDeviceProfession()));
            deviceEto.setPartModel(part_modelMapper.selectByID(o.getDevicePart()));
            deviceEtos.add(deviceEto);
        }

        return deviceEtos;
    }

    /**
     *
     * 查询单个设备信息
     * @param device_id
     * @return 耦合DeviceEto
     */
    @Override
    public DeviceEto selectDevice(String device_id) {

        deviceEto.setDevice(deviceMapper.selectByID(device_id));

        deviceEto.setDeviceModel(device_modelMapper.selectByID( deviceMapper.selectByID(device_id).getDeviceModel()));
        deviceEto.setProfModel(prof_modelMapper.selectByID( deviceMapper.selectByID(device_id).getDeviceProfession()));
        deviceEto.setPartModel(part_modelMapper.selectByID(deviceMapper.selectByID(device_id).getDevicePart()));

        return deviceEto;
    }
}
