
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
                           `id` bigint(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
                           `user_name` varchar(100) NOT NULL COMMENT '账户名称',
                           `pass_word` varchar(100) NOT NULL COMMENT '登录密码',
                           `nick_name` varchar(30) NOT NULL COMMENT '昵称',
                           `mobile` varchar(30) NOT NULL COMMENT '手机号',
                           `email` varchar(100) DEFAULT NULL COMMENT '邮箱地址',
                           `gmt_create` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                           `gmt_update` timestamp NULL DEFAULT NULL COMMENT '更新时间',
                           PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT 'Mybatis Demo';

-- ----------------------------
-- Records of user_info
-- ----------------------------
BEGIN;
INSERT INTO `user_info` VALUES (1, 'Van', '123456', '风尘', '12580', NULL, '2020-02-01 14:52:12', NULL);
INSERT INTO `user_info` VALUES (2, 'zhangsan', '123456', '张三', '12580', NULL, '2020-01-02 14:52:12', NULL);
INSERT INTO `user_info` VALUES (3, 'lisi', '123456', '李四', '12580', NULL, '2020-02-01 14:52:12', NULL);
INSERT INTO `user_info` VALUES (4, 'wanger', '123456', '王二', '12580', NULL, '2020-02-02 15:48:34', NULL);
INSERT INTO `user_info` VALUES (5, 'wangwu', '123456', '王五', '12580', NULL, '2020-02-02 15:48:56', NULL);
COMMIT;
