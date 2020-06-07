DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_name` varchar(10) NOT NULL COMMENT '用户名',
  `pass_word` varchar(10) NOT NULL COMMENT '密码',
  `user_sex` varchar(10) DEFAULT NULL COMMENT '性别',
  `nick_name` varchar(10) DEFAULT NULL COMMENT '昵称',
  `gmt_create` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;