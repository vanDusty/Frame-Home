/*
Navicat MySQL Data Transfer

Source Server         : meiren-local-dev
Source Server Version : 50636
Source Host           : 192.168.4.100:3306
Source Database       : van_member

Target Server Type    : MYSQL
Target Server Version : 50636
File Encoding         : 65001

Date: 2018-09-17 15:28:16
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user_id_list
-- ----------------------------
DROP TABLE IF EXISTS `user_id_list`;
CREATE TABLE `user_id_list` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `is_user` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_id_list
-- ----------------------------
INSERT INTO `user_id_list` VALUES ('1', '1');
INSERT INTO `user_id_list` VALUES ('2', '1');
INSERT INTO `user_id_list` VALUES ('3', '1');
INSERT INTO `user_id_list` VALUES ('4', '1');
INSERT INTO `user_id_list` VALUES ('5', '1');
INSERT INTO `user_id_list` VALUES ('6', '1');
INSERT INTO `user_id_list` VALUES ('7', '1');
INSERT INTO `user_id_list` VALUES ('8', '1');
INSERT INTO `user_id_list` VALUES ('9', '1');
INSERT INTO `user_id_list` VALUES ('10', '1');
INSERT INTO `user_id_list` VALUES ('11', '1');
INSERT INTO `user_id_list` VALUES ('12', '1');

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  `user_name` varchar(255) NOT NULL DEFAULT '' COMMENT '用户账号',
  `nick_name` varchar(255) CHARACTER SET utf8mb4 NOT NULL COMMENT '用户昵称',
  `phone` varchar(255) DEFAULT '0' COMMENT '用户手机号',
  `e_mail` varchar(255) DEFAULT '0' COMMENT '邮箱',
  `password` varchar(255) NOT NULL COMMENT '密码'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES ('7', 'van', 'FFFF', '0', '0', '123456');
INSERT INTO `user_info` VALUES ('8', 'van', 'van', '0', '0', '123456');

-- ----------------------------
-- Table structure for user_info_0
-- ----------------------------
DROP TABLE IF EXISTS `user_info_0`;
CREATE TABLE `user_info_0` (
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  `user_name` varchar(255) NOT NULL DEFAULT '' COMMENT '用户账号',
  `nick_name` varchar(255) CHARACTER SET utf8mb4 NOT NULL COMMENT '用户昵称',
  `phone` varchar(255) DEFAULT '0' COMMENT '用户手机号',
  `e_mail` varchar(255) DEFAULT '0' COMMENT '邮箱',
  `password` varchar(255) NOT NULL COMMENT '密码'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_info_0
-- ----------------------------
INSERT INTO `user_info_0` VALUES ('10', 'van', '888', '0', '0', '123456');

-- ----------------------------
-- Table structure for user_info_1
-- ----------------------------
DROP TABLE IF EXISTS `user_info_1`;
CREATE TABLE `user_info_1` (
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  `user_name` varchar(255) NOT NULL DEFAULT '' COMMENT '用户账号',
  `nick_name` varchar(255) CHARACTER SET utf8mb4 NOT NULL COMMENT '用户昵称',
  `phone` varchar(255) DEFAULT '0' COMMENT '用户手机号',
  `e_mail` varchar(255) DEFAULT '0' COMMENT '邮箱',
  `password` varchar(255) NOT NULL COMMENT '密码'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_info_1
-- ----------------------------
INSERT INTO `user_info_1` VALUES ('11', 'vangsdgd', 'gdsgsdg', '0', '0', '123456');

-- ----------------------------
-- Table structure for user_info_2
-- ----------------------------
DROP TABLE IF EXISTS `user_info_2`;
CREATE TABLE `user_info_2` (
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  `user_name` varchar(255) NOT NULL DEFAULT '' COMMENT '用户账号',
  `nick_name` varchar(255) CHARACTER SET utf8mb4 NOT NULL COMMENT '用户昵称',
  `phone` varchar(255) DEFAULT '0' COMMENT '用户手机号',
  `e_mail` varchar(255) DEFAULT '0' COMMENT '邮箱',
  `password` varchar(255) NOT NULL COMMENT '密码'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_info_2
-- ----------------------------
INSERT INTO `user_info_2` VALUES ('12', 'van', 'fsdgsdgd', '0', '0', '123456');

-- ----------------------------
-- Table structure for user_info_3
-- ----------------------------
DROP TABLE IF EXISTS `user_info_3`;
CREATE TABLE `user_info_3` (
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  `user_name` varchar(255) NOT NULL DEFAULT '' COMMENT '用户账号',
  `nick_name` varchar(255) CHARACTER SET utf8mb4 NOT NULL COMMENT '用户昵称',
  `phone` varchar(255) DEFAULT '0' COMMENT '用户手机号',
  `e_mail` varchar(255) DEFAULT '0' COMMENT '邮箱',
  `password` varchar(255) NOT NULL COMMENT '密码'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_info_3
-- ----------------------------

-- ----------------------------
-- Table structure for user_info_4
-- ----------------------------
DROP TABLE IF EXISTS `user_info_4`;
CREATE TABLE `user_info_4` (
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  `user_name` varchar(255) NOT NULL DEFAULT '' COMMENT '用户账号',
  `nick_name` varchar(255) CHARACTER SET utf8mb4 NOT NULL COMMENT '用户昵称',
  `phone` varchar(255) DEFAULT '0' COMMENT '用户手机号',
  `e_mail` varchar(255) DEFAULT '0' COMMENT '邮箱',
  `password` varchar(255) NOT NULL COMMENT '密码'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_info_4
-- ----------------------------

-- ----------------------------
-- Table structure for user_info_5
-- ----------------------------
DROP TABLE IF EXISTS `user_info_5`;
CREATE TABLE `user_info_5` (
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  `user_name` varchar(255) NOT NULL DEFAULT '' COMMENT '用户账号',
  `nick_name` varchar(255) CHARACTER SET utf8mb4 NOT NULL COMMENT '用户昵称',
  `phone` varchar(255) DEFAULT '0' COMMENT '用户手机号',
  `e_mail` varchar(255) DEFAULT '0' COMMENT '邮箱',
  `password` varchar(255) NOT NULL COMMENT '密码'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_info_5
-- ----------------------------

-- ----------------------------
-- Table structure for user_info_6
-- ----------------------------
DROP TABLE IF EXISTS `user_info_6`;
CREATE TABLE `user_info_6` (
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  `user_name` varchar(255) NOT NULL DEFAULT '' COMMENT '用户账号',
  `nick_name` varchar(255) CHARACTER SET utf8mb4 NOT NULL COMMENT '用户昵称',
  `phone` varchar(255) DEFAULT '0' COMMENT '用户手机号',
  `e_mail` varchar(255) DEFAULT '0' COMMENT '邮箱',
  `password` varchar(255) NOT NULL COMMENT '密码'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_info_6
-- ----------------------------

-- ----------------------------
-- Table structure for user_info_7
-- ----------------------------
DROP TABLE IF EXISTS `user_info_7`;
CREATE TABLE `user_info_7` (
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  `user_name` varchar(255) NOT NULL DEFAULT '' COMMENT '用户账号',
  `nick_name` varchar(255) CHARACTER SET utf8mb4 NOT NULL COMMENT '用户昵称',
  `phone` varchar(255) DEFAULT '0' COMMENT '用户手机号',
  `e_mail` varchar(255) DEFAULT '0' COMMENT '邮箱',
  `password` varchar(255) NOT NULL COMMENT '密码'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_info_7
-- ----------------------------

-- ----------------------------
-- Table structure for user_info_8
-- ----------------------------
DROP TABLE IF EXISTS `user_info_8`;
CREATE TABLE `user_info_8` (
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  `user_name` varchar(255) NOT NULL DEFAULT '' COMMENT '用户账号',
  `nick_name` varchar(255) CHARACTER SET utf8mb4 NOT NULL COMMENT '用户昵称',
  `phone` varchar(255) DEFAULT '0' COMMENT '用户手机号',
  `e_mail` varchar(255) DEFAULT '0' COMMENT '邮箱',
  `password` varchar(255) NOT NULL COMMENT '密码'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_info_8
-- ----------------------------

-- ----------------------------
-- Table structure for user_info_9
-- ----------------------------
DROP TABLE IF EXISTS `user_info_9`;
CREATE TABLE `user_info_9` (
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  `user_name` varchar(255) NOT NULL DEFAULT '' COMMENT '用户账号',
  `nick_name` varchar(255) CHARACTER SET utf8mb4 NOT NULL COMMENT '用户昵称',
  `phone` varchar(255) DEFAULT '0' COMMENT '用户手机号',
  `e_mail` varchar(255) DEFAULT '0' COMMENT '邮箱',
  `password` varchar(255) NOT NULL COMMENT '密码'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_info_9
-- ----------------------------
INSERT INTO `user_info_9` VALUES ('9', 'van', 'gsdgdsg', '0', '0', '123456');
