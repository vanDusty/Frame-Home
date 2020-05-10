DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` bigint(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `user_name` varchar(100) NOT NULL COMMENT '账户名称',
  `gmt_create` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_update` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='用户表';

INSERT INTO `user` (`id`, `user_name`, `gmt_create`, `gmt_update`)
VALUES
	(1,'Van','2020-05-09 18:09:16',NULL),
	(2,'VanFan','2020-05-10 17:45:25',NULL);

DROP TABLE IF EXISTS `user_info`;

CREATE TABLE `user_info` (
  `id` bigint(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `pass_word` varchar(100) NOT NULL COMMENT '登录密码',
  `nick_name` varchar(30) NOT NULL COMMENT '昵称',
  `mobile` varchar(30) NOT NULL COMMENT '手机号',
  `email` varchar(100) DEFAULT NULL COMMENT '邮箱地址',
  `gmt_create` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_update` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='用户信息表';

INSERT INTO `user_info` (`id`, `user_id`, `pass_word`, `nick_name`, `mobile`, `email`, `gmt_create`, `gmt_update`)
VALUES
	(1,1,'password','风尘博客','12580','110@qq.com','2020-02-09 18:05:27',NULL),
	(2,2,'password','公众号','110','12580@qq.com','2020-02-10 17:45:45',NULL);