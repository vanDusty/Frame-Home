
DROP TABLE IF EXISTS `user_info_batch`;
CREATE TABLE `user_info_batch` (
                           `id` bigint(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
                           `user_name` varchar(100) NOT NULL COMMENT '账户名称',
                           `pass_word` varchar(100) NOT NULL COMMENT '登录密码',
                           `nick_name` varchar(30) NOT NULL COMMENT '昵称',
                           `mobile` varchar(30) NOT NULL COMMENT '手机号',
                           `email` varchar(100) DEFAULT NULL COMMENT '邮箱地址',
                           `gmt_create` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                           `gmt_update` timestamp NULL DEFAULT NULL COMMENT '更新时间',
                           PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT 'Mybatis Batch';