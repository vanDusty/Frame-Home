DROP TABLE IF EXISTS `mybatis_plus_meta_fill`;

create table mybatis_plus_meta_fill
(
    `id`          bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `status`      tinyint(1) NOT NULL COMMENT '状态',
    `deleted`   tinyint(1) NOT NULL COMMENT '删除标识',
    `create_time` timestamp   NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
    `update_time` timestamp   NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '更新时间',
    `create_by` varchar(10)   NOT NULL COMMENT '创建者',
    `update_by` varchar(10)   NOT NULL COMMENT '更新者',
    primary key (`id`)
) engine=innodb auto_increment=1 comment = 'Mybatis-plus字段自动填充';