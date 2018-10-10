/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50723
Source Host           : localhost:3306
Source Database       : dorm

Target Server Type    : MYSQL
Target Server Version : 50723
File Encoding         : 65001

Date: 2018-10-09 19:32:03
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for check_work_info
-- ----------------------------
DROP TABLE IF EXISTS `check_work_info`;
CREATE TABLE `check_work_info` (
  `check_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '宿检时间',
  `dorm_id` varchar(50) NOT NULL COMMENT '宿舍编号',
  `dorm_address` varchar(20) DEFAULT NULL COMMENT '宿舍地址:南区、东区',
  `dorm_no` varchar(50) DEFAULT NULL COMMENT '宿舍房间号：101',
  `bed_no` varchar(10) DEFAULT NULL COMMENT '学生的床位',
  `stu_id` varchar(100) DEFAULT NULL COMMENT '学生的学号',
  `stu_name` varchar(200) DEFAULT NULL COMMENT '学生的姓名',
  `reason` varchar(255) DEFAULT '不详' COMMENT '夜不归宿的原因',
  PRIMARY KEY (`check_time`,`dorm_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for device
-- ----------------------------
DROP TABLE IF EXISTS `device`;
CREATE TABLE `device` (
  `dorm_id` varchar(50) NOT NULL COMMENT '宿舍编号',
  `dorm_address` varchar(20) DEFAULT NULL COMMENT '宿舍地址:南区、东区',
  `dorm_no` varchar(50) DEFAULT NULL COMMENT '宿舍房间号：101',
  `device_name` varchar(50) NOT NULL COMMENT '设备的名称',
  `device_number` int(11) DEFAULT '0' COMMENT '设备的数量',
  PRIMARY KEY (`dorm_id`,`device_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for dorm
-- ----------------------------
DROP TABLE IF EXISTS `dorm`;
CREATE TABLE `dorm` (
  `dorm_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '宿舍编号',
  `dorm_address` varchar(20) DEFAULT NULL COMMENT '宿舍地址:南区、东区',
  `dorm_no` varchar(50) DEFAULT NULL COMMENT '宿舍房间号：101',
  `dorm_hold` int(11) DEFAULT NULL COMMENT '宿舍可容纳人数',
  `dorm_status` int(11) DEFAULT '0' COMMENT '宿舍是否在使用',
  `dorm_use_person` int(11) DEFAULT NULL COMMENT '当前宿舍入住的人数',
  PRIMARY KEY (`dorm_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10000 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for dorm_check
-- ----------------------------
DROP TABLE IF EXISTS `dorm_check`;
CREATE TABLE `dorm_check` (
  `check_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '宿检时间',
  `dorm_id` varchar(50) NOT NULL COMMENT '宿舍编号',
  `dorm_address` varchar(20) DEFAULT NULL COMMENT '宿舍地址:南区、东区',
  `dorm_no` varchar(50) DEFAULT NULL COMMENT '宿舍房间号：101',
  `dorm_rubbish` int(11) DEFAULT '0' COMMENT '宿舍垃圾',
  `dorm_bed_health` int(11) DEFAULT '0' COMMENT '宿舍卫生',
  `dorm_balcony_health` int(11) DEFAULT '0' COMMENT '阳台卫生',
  `dorm_wc_health` int(11) DEFAULT '0' COMMENT '洗手间卫生',
  PRIMARY KEY (`check_time`,`dorm_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for dorm_consume
-- ----------------------------
DROP TABLE IF EXISTS `dorm_consume`;
CREATE TABLE `dorm_consume` (
  `dorm_address` varchar(20) NOT NULL COMMENT '宿舍地址:南区、东区',
  `dorm_no` varchar(50) NOT NULL COMMENT '宿舍房间号：101',
  `month_time` varchar(100) DEFAULT NULL COMMENT '该电费的月份',
  `cost_type` varchar(50) DEFAULT NULL COMMENT '该费用的类型，如电费，水费',
  `cost` double DEFAULT NULL COMMENT '具体费用',
  `cost_status` int(11) DEFAULT '0' COMMENT '是否支付',
  PRIMARY KEY (`dorm_address`,`dorm_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for dorm_info
-- ----------------------------
DROP TABLE IF EXISTS `dorm_info`;
CREATE TABLE `dorm_info` (
  `dorm_id` varchar(50) NOT NULL COMMENT '宿舍编号',
  `dorm_address` varchar(20) DEFAULT NULL COMMENT '宿舍地址:南区、东区',
  `dorm_no` varchar(50) DEFAULT NULL COMMENT '宿舍房间号：101',
  `check_in__time` varchar(100) DEFAULT NULL COMMENT '学生的入住时间',
  `stu_id` varchar(100) NOT NULL COMMENT '学生的学号',
  `stu_name` varchar(200) DEFAULT NULL COMMENT '学生的姓名',
  `stu_sex` varchar(20) DEFAULT '男' COMMENT '学生的性别',
  `bed_no` varchar(10) DEFAULT NULL COMMENT '学生的床位',
  `check_situation` int(11) DEFAULT '1' COMMENT '当前给学生的入住情况:1表示入住，0表示未入住',
  PRIMARY KEY (`dorm_id`,`stu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for leave_school
-- ----------------------------
DROP TABLE IF EXISTS `leave_school`;
CREATE TABLE `leave_school` (
  `dorm_id` varchar(50) DEFAULT NULL COMMENT '宿舍编号',
  `dorm_address` varchar(20) DEFAULT NULL COMMENT '宿舍地址:南区、东区',
  `dorm_no` varchar(50) DEFAULT NULL COMMENT '宿舍房间号：101',
  `stu_id` varchar(50) DEFAULT NULL COMMENT '学生的学号',
  `stu_name` varchar(200) DEFAULT NULL COMMENT '学生的姓名',
  `leave_reason` varchar(255) DEFAULT '家里有事' COMMENT '请假原因',
  `start_time` varchar(100) DEFAULT NULL COMMENT '请假开始时间',
  `end_time` varchar(100) DEFAULT NULL COMMENT '请假结束时间',
  `return_whether` int(11) DEFAULT '0' COMMENT '是否已经返回学校'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for network_address
-- ----------------------------
DROP TABLE IF EXISTS `network_address`;
CREATE TABLE `network_address` (
  `dorm_id` varchar(50) NOT NULL COMMENT '宿舍编号',
  `dorm_address` varchar(20) DEFAULT NULL COMMENT '宿舍地址:南区、东区',
  `dorm_no` varchar(50) DEFAULT NULL COMMENT '宿舍房间号：101',
  `bed_no` varchar(10) NOT NULL COMMENT '学生的床位',
  `ip_address` varchar(200) DEFAULT NULL COMMENT 'ip地址',
  `subnet` varchar(200) DEFAULT NULL COMMENT '子网掩码',
  `default_net` varchar(200) DEFAULT NULL COMMENT '默认网关',
  `first_dns` varchar(200) DEFAULT NULL COMMENT '首选dns服务器',
  `spare_dns` varchar(200) DEFAULT NULL COMMENT '备用dns服务器',
  `last_cast_time` varchar(100) DEFAULT NULL COMMENT '上一次的扣费时间',
  `balance` int(11) DEFAULT '0' COMMENT '网费余额',
  PRIMARY KEY (`dorm_id`,`bed_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for repair_info
-- ----------------------------
DROP TABLE IF EXISTS `repair_info`;
CREATE TABLE `repair_info` (
  `repair_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '维修单编号',
  `dorm_address` varchar(20) DEFAULT NULL COMMENT '宿舍地址:南区、东区',
  `dorm_no` varchar(50) DEFAULT NULL COMMENT '宿舍房间号：101',
  `repair_instrument` varchar(100) DEFAULT NULL COMMENT '需要修理的仪器名称',
  `repair_reason` varchar(255) DEFAULT NULL COMMENT '维修的原因',
  `repair_situation` int(11) DEFAULT '0' COMMENT '处理情况，0表示待处理，1表示未处理',
  `apply_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '申请的时间',
  `handle_time` varchar(150) DEFAULT '' COMMENT '处理完毕的时间',
  PRIMARY KEY (`repair_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
