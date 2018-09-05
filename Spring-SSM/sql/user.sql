/*
Navicat MySQL Data Transfer

Source Server         : meiren-local-dev
Source Server Version : 50636
Source Host           : 192.168.4.100:3306
Source Database       : van_member

Target Server Type    : MYSQL
Target Server Version : 50636
File Encoding         : 65001

Date: 2018-08-09 17:24:50
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `user_name` varchar(255) NOT NULL DEFAULT '' COMMENT '用户账号',
  `nick_name` varchar(255) CHARACTER SET utf8mb4 NOT NULL COMMENT '用户昵称',
  `phone` varchar(255) DEFAULT '0' COMMENT '用户手机号',
  `e_mail` varchar(255) DEFAULT '0' COMMENT '邮箱',
  `password` varchar(255) NOT NULL COMMENT '密码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'van', 'van', '0', '0', '123456');
