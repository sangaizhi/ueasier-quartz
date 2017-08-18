/*
Navicat MySQL Data Transfer

Source Server         : localhost_4406
Source Server Version : 50525
Source Host           : 127.0.0.1:4406
Source Database       : ueasier_quartz

Target Server Type    : MYSQL
Target Server Version : 50525
File Encoding         : 65001

Date: 2017-08-18 09:31:14
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_order
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `t_code` varchar(128) DEFAULT NULL,
  `t_amount` decimal(10,2) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `user_name` varchar(100) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_schedule_job
-- ----------------------------
DROP TABLE IF EXISTS `t_schedule_job`;
CREATE TABLE `t_schedule_job` (
  `job_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '作业ID',
  `job_name` varchar(254) NOT NULL DEFAULT '' COMMENT '作业名称',
  `job_group` varchar(254) NOT NULL DEFAULT '' COMMENT '作业分组',
  `job_status` varchar(254) DEFAULT NULL COMMENT '作业状态：是否启动作业',
  `job_cron` varchar(254) DEFAULT NULL COMMENT '作业的 cron 表达式',
  `job_desc` varchar(254) DEFAULT NULL COMMENT '作业描述',
  `job_class` varchar(254) DEFAULT NULL COMMENT '作业执行的类名',
  `job_method` varchar(254) DEFAULT NULL COMMENT '作业执行的方法名',
  `job_is_concurrent` varchar(254) DEFAULT NULL COMMENT '任务是否有状态',
  `job_spring_id` varchar(254) DEFAULT NULL COMMENT '任务执行的springbean',
  `create_time` datetime DEFAULT NULL COMMENT '作业创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '作业更新时间',
  PRIMARY KEY (`job_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
