/*
Navicat MySQL Data Transfer

Source Server         : meiren-local-dev
Source Server Version : 50636
Source Host           : 192.168.4.100:3306
Source Database       : van_member

Target Server Type    : MYSQL
Target Server Version : 50636
File Encoding         : 65001

Date: 2018-08-25 01:46:30
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for transfer
-- ----------------------------
DROP TABLE IF EXISTS `transfer`;
CREATE TABLE `transfer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) NOT NULL DEFAULT '0',
  `user_account` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of transfer
-- ----------------------------
INSERT INTO `transfer` VALUES ('1', '张三', '1700');
INSERT INTO `transfer` VALUES ('2', '李四', '100');
INSERT INTO `transfer` VALUES ('3', '王二', '1100');
