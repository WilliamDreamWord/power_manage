/*
 Navicat Premium Data Transfer

 Source Server         : local-mysql
 Source Server Type    : MySQL
 Source Server Version : 50722
 Source Host           : localhost:3306
 Source Schema         : power_manager

 Target Server Type    : MySQL
 Target Server Version : 50722
 File Encoding         : 65001

 Date: 20/10/2018 10:41:11
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for cable
-- ----------------------------
DROP TABLE IF EXISTS `cable`;
CREATE TABLE `cable` (
  `id` int(100) NOT NULL AUTO_INCREMENT COMMENT '数据库表id',
  `cable_id` varchar(100) NOT NULL COMMENT '线缆id',
  `cable_profession` varchar(100) NOT NULL COMMENT '线缆所属专业',
  `local_device` varchar(100) NOT NULL COMMENT '本端设备',
  `local_deviceLocation` varchar(100) NOT NULL COMMENT '本端设备位置',
  `local_port` varchar(100) NOT NULL COMMENT '本地端口',
  `local_addressCode` varchar(100) NOT NULL COMMENT '本端地址码',
  `peer_device` varchar(100) DEFAULT NULL COMMENT '对端设备',
  `peer_port` varchar(100) DEFAULT NULL COMMENT '对端端口',
  `peer_addressCode` varchar(100) NOT NULL COMMENT '对端地址码',
  `begin_point` varchar(100) NOT NULL COMMENT '起止点',
  `end_point` varchar(100) DEFAULT NULL COMMENT '终止点',
  `buiness_name` varchar(100) NOT NULL COMMENT '业务名称',
  `cable_part` varchar(100) NOT NULL COMMENT '线缆分区',
  `cable_price` varchar(20) DEFAULT NULL COMMENT '线缆价格',
  `cable_remark` text DEFAULT NULL COMMENT '线缆备注',
  `create_date` varchar(20) DEFAULT NULL COMMENT '创建时间',
  `update_date` varchar(20) DEFAULT NULL COMMENT '修改时间/只记录最近一次修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cable
-- ----------------------------
BEGIN;
INSERT INTO `cable` VALUES (1, 'AFJAF', '信息', 'his1历史服务器#1his1历史服务器#1', '5楼60柜9U', 'eth1', '1H-60R-9U-eth1', NULL, NULL, '1H-57R-25U-GE0/0/4', 'his1-一区主干网交换机#1', NULL, '一区主干网交换机#1', '一区', NULL, NULL, NOW(), NULL);
COMMIT;

-- ----------------------------
-- Table structure for terminal
-- ----------------------------
DROP TABLE IF EXISTS `terminal`;
CREATE TABLE `terminal` (
  `id` int(100) NOT NULL AUTO_INCREMENT COMMENT '数据库表id',
  `terminal_id` varchar(100) NOT NULL COMMENT '终端id',
  `terminal_profession` varchar(50) NOT NULL COMMENT '终端所属专业',
  `termianl_name` varchar(50) NOT NULL COMMENT '终端名称',
  `termianl_person` varchar(50) NOT NULL COMMENT '终端持有人',
  `person_phone` varchar(20) NOT NULL COMMENT '持有人电话',
  `terminal_dept` varchar(20) NOT NULL COMMENT '终端所属部门',
  `release_time` varchar(50) NOT NULL COMMENT '发放时间',
  `reflux_time` varchar(50) DEFAULT NULL COMMENT '回流时间',
  `terminal_status` int(10) DEFAULT '0' COMMENT '终端状况/初始为0：正常；开发人员可根据实际情况自主设置',
  `fix_status` int(10) DEFAULT '0' COMMENT '保修状态/初始为0：未保修；开发人员可根据实际情况自主设置',
  `terminal_price` varchar(20) DEFAULT NULL COMMENT '终端价格',
  `terminal_remark` text DEFAULT NULL COMMENT '终端备注',
  `create_date` varchar(20) DEFAULT NULL COMMENT '创建时间',
  `update_date` varchar(20) DEFAULT NULL COMMENT '修改时间/只记录最近一次修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of terminal
-- ----------------------------
BEGIN;
INSERT INTO `terminal` VALUES (1, 'AFAaf','信息','苹果一体机','方玉斌','15803067129','行政部','2018/4/24',null,0,0,null, null, NOW(),NULL );
COMMIT;

-- ----------------------------
-- Table structure for terminal_failure
-- ----------------------------
DROP TABLE IF EXISTS `terminal_failure`;
CREATE TABLE `terminal_failure` (
  `id` int(100) NOT NULL AUTO_INCREMENT COMMENT '数据库表id',
  `failure_id` varchar(100) NOT NULL COMMENT '故障id',
  `terminal_id` varchar(100) NOT NULL COMMENT '终端id',
  `failure_symptom` text DEFAULT NULL COMMENT '故障现象',
  `failure_desc` text DEFAULT NULL COMMENT '故障描述',
  `begin_time` varchar(20) DEFAULT NULL COMMENT '故障开始时间',
  `fix_time` varchar(20) NOT NULL COMMENT '报修时间',
  `begin_fixTime` varchar(20) NOT NULL COMMENT '起始维修时间',
  `end_fixTime` varchar(20) NOT NULL COMMENT '维修完成时间',
  `fix_person` varchar(20) DEFAULT NULL COMMENT '维修人',
  `fix_phone` varchar(20) DEFAULT NULL COMMENT '维修人联系电话',
  `failure_status` int(10) DEFAULT '0' COMMENT '维修状态/初始为0：未维修；开发者可根据实际情况自主设置',
  `failure_cost` varchar(20) DEFAULT NULL COMMENT '维修花费',
  `create_date` varchar(20) DEFAULT NULL COMMENT '创建时间',
  `update_date` varchar(20) DEFAULT NULL COMMENT '修改时间/只记录最近一次修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of terminal_failure
-- ----------------------------
BEGIN;
INSERT INTO `terminal_failure` VALUES (1, 'AFJBA','AFAaf','现状1','太丑', NULL, NOW(), NOW(), NOW(), NULL, NULL, '0', NULL, NOW(), NULL);
COMMIT;

-- ----------------------------
-- Table structure for device_model
-- ----------------------------
DROP TABLE IF EXISTS `device_model`;
CREATE TABLE `device_model` (
  `id` int(100) NOT NULL AUTO_INCREMENT COMMENT '数据库表id',
  `deviceM_id` varchar(100) NOT NULL COMMENT '设备类型id',
  `deviceM_name` varchar(100) NOT NULL COMMENT '设备类型名称',
  `deviceM_price` varchar(100) DEFAULT NULL COMMENT '设备类型平均价格',
  `extends_attri1` varchar(100) DEFAULT NULL COMMENT '扩展属性1',
  `extends_attri2` varchar(100) DEFAULT NULL COMMENT '扩展属性2',
  `extends_attri3` varchar(100) DEFAULT NULL COMMENT '扩展属性3',
  `extends_attri4` varchar(100) DEFAULT NULL COMMENT '扩展属性4',
  `extends_attri5` varchar(100) DEFAULT NULL COMMENT '扩展属性5',
  `extends_remark` text DEFAULT NULL COMMENT '设备类型描述',
  `create_date` varchar(20) DEFAULT NULL COMMENT '创建时间',
  `update_date` varchar(20) DEFAULT NULL COMMENT '修改时间/只记录最近一次修改时间',
  PRIMARY KEY (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of device_model
-- ----------------------------
BEGIN;
INSERT INTO `device_model` VALUES (1, 'AFBKJA','交换机',NULL, NULL, NULL, NULL, NULL, NULL, NULL, NOW(), NULL);
COMMIT;

-- ----------------------------
-- Table structure for profession_model
-- ----------------------------
DROP TABLE IF EXISTS `profession_model`;
CREATE TABLE `profession_model` (
  `id` int(100) NOT NULL AUTO_INCREMENT COMMENT '数据库表id',
  `profM_id` varchar(100) NOT NULL COMMENT '专业类型id',
  `proM_name` varchar(100) NOT NULL COMMENT '专业名称',
  `proM_num` varchar(20) DEFAULT NULL COMMENT '专业内总人数/总设备',
  `proM_remark` text DEFAULT NULL COMMENT '专业类型描述',
  `create_date` varchar(20) DEFAULT NULL COMMENT '创建时间',
  `update_date` varchar(20) DEFAULT NULL COMMENT '修改时间/只记录最近一次修改时间',
  PRIMARY KEY (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of profession_model
-- ----------------------------
BEGIN;
INSERT INTO `profession_model` VALUES (1, 'ajfja','信息',NULL,NULL, NOW(), NULL);
COMMIT;

-- ----------------------------
-- Table structure for part_model
-- ----------------------------
DROP TABLE IF EXISTS `part_model`;
CREATE TABLE `part_model` (
  `id` int(100) NOT NULL AUTO_INCREMENT COMMENT '数据库表id',
  `partM_id` varchar(100) NOT NULL COMMENT '分区类型id',
  `partM_name` varchar(100) NOT NULL COMMENT '分区类型名称',
  `partM_num` varchar(100) DEFAULT NULL COMMENT '分区类型总人数/总设备',
  `partM_remark` text DEFAULT NULL COMMENT '分区类型描述',
  `create_date` varchar(20) DEFAULT NULL COMMENT '创建时间',
  `update_date` varchar(20) DEFAULT NULL COMMENT '修改时间/只记录最近一次修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of part_model
-- ----------------------------
BEGIN;
INSERT INTO `part_model` VALUES (1, 'AFIA', '一区', NULL, NULL, NOW(), NULL);
COMMIT;

-- ----------------------------
-- Table structure for department_model
-- ----------------------------
DROP TABLE IF EXISTS `department_model`;
CREATE TABLE `department_model` (
  `id` int(100) NOT NULL AUTO_INCREMENT COMMENT '数据库表id',
  `deptM_id` varchar(100) NOT NULL COMMENT '部门类型id',
  `deptM_name` varchar(100) NOT NULL COMMENT '部门类型名称',
  `deptM_num` varchar(100) DEFAULT NULL COMMENT '部门所属下总人数/总设备',
  `deptM_person` varchar(20) DEFAULT NULL COMMENT '部门主管',
  `deptM_remark` text DEFAULT NULL COMMENT '部门描述',
  `create_date` varchar(20) DEFAULT NULL COMMENT '创建时间',
  `update_date` varchar(20) DEFAULT NULL COMMENT '修改时间/只记录最近一次修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of
-- ----------------------------
BEGIN;
INSERT INTO `department_model` VALUES (1, 'AFAF', '材料', NULL, NULL, NULL, NOW(), NULL);
COMMIT;

-- ----------------------------
-- Table structure for device
-- ----------------------------
DROP TABLE IF EXISTS `device`;
CREATE TABLE `device` (
  `id` int(100) NOT NULL AUTO_INCREMENT COMMENT '数据库表id',
  `device_id` varchar(100) NOT NULL COMMENT '设备id',
  `device_profession` varchar(50) NOT NULL COMMENT '设备所属专业',
  `device_name` varchar(100) NOT NULL COMMENT '设备名称',
  `device_model` varchar(100) NOT NULL COMMENT '设备型号',
  `device_location` varchar(100) NOT NULL COMMENT '设备位置',
  `maintence_person` varchar(20) NOT NULL COMMENT '维护责任人',
  `opera_time` varchar(20) NOT NULL COMMENT '投运时间',
  `contract_phone` varchar(20) NOT NULL COMMENT '联系电话',
  `device_part` varchar(20) NOT NULL COMMENT '设备分区',
  `device_status` int(10) DEFAULT '0' COMMENT '设备状况/，初始 0：正常；开发人员可根据实际情况自主设置',
  `device_price` varchar(20) DEFAULT NULL COMMENT '设备价格',
  `device_remark` text DEFAULT NULL COMMENT '设备备注',
  `create_date` varchar(20) DEFAULT NULL COMMENT '创建时间',
  `update_date` varchar(20) DEFAULT NULL COMMENT '修改时间/只记录最近一次修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of device
-- ----------------------------
BEGIN;
INSERT INTO `device` VALUES (1, 'afba241', '信息', 'macbook pro', '2015', '1H-27R-35U', '向曦', '2014/3/12', '18983841660', '二区', 0, NULL, NULL, NOW(), NULL);
COMMIT;

-- ----------------------------
-- Table structure for manager
-- ----------------------------
DROP TABLE IF EXISTS `manager`;
CREATE TABLE `manager` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '数据库表id',
  `manager_id` varchar(100) NOT NULL COMMENT '管理者id',
  `manager_name` varchar(20) NOT NULL COMMENT '管理者name',
  `manager_phone` varchar(100) NOT NULL COMMENT '管理者phone',
  `account_name` varchar(20) NOT NULL COMMENT '登陆账号name',
  `account_pass` varchar(20) NOT NULL COMMENT '登陆密码',
  `create_date` varchar(20) DEFAULT NULL COMMENT '创建时间',
  `update_date` varchar(20) DEFAULT NULL COMMENT '修改时间/只记录最近一次修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of manager
-- ----------------------------
BEGIN;
INSERT INTO `manager` VALUES (1, '23rjaf', '管理者', '13042373156', 'admin', '123456', NOW(), NULL);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
