USE `master`;
DROP TABLE IF EXISTS `user_info_0`;
CREATE TABLE `user_info_0` (
                        `id` int(10) NOT NULL COMMENT '用户id',
                        `user_name` varchar(50) NOT NULL COMMENT '用户名',
                        `user_age` int(3) DEFAULT '0' COMMENT '用户年龄',
                        PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='master 用户表';

DROP TABLE IF EXISTS `user_info_1`;
CREATE TABLE `user_info_1` (
                        `id` int(10) NOT NULL COMMENT '用户id',
                        `user_name` varchar(50) NOT NULL COMMENT '用户名',
                        `user_age` int(3) DEFAULT '0' COMMENT '用户年龄',
                        PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='master 用户表';

USE `slave`;
DROP TABLE IF EXISTS `user_info_0`;
CREATE TABLE `user_info_0` (
                        `id` int(10) NOT NULL COMMENT '用户id',
                        `user_name` varchar(50) NOT NULL COMMENT '用户名',
                        `user_age` int(3) DEFAULT '0' COMMENT '用户年龄',
                        PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='slave 用户表';

DROP TABLE IF EXISTS `user_info_1`;
CREATE TABLE `user_info_1` (
                        `id` int(10) NOT NULL COMMENT '用户id',
                        `user_name` varchar(50) NOT NULL COMMENT '用户名',
                        `user_age` int(3) DEFAULT '0' COMMENT '用户年龄',
                        PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='slave 用户表';