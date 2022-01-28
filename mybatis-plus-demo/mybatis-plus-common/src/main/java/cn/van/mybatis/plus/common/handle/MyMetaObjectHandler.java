package cn.van.mybatis.plus.common.handle;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.context.annotation.Configuration;
import java.util.Date;


/**
 * Copyright (C), 2015-2022, 风尘博客
 * 公众号 : 风尘博客
 * @Author:   Van
 * Date:     2022/1/6 11:49 下午
 * Description: 配置填充策略
 * Version： V1.0
 */

@Configuration
@Slf4j
public class MyMetaObjectHandler implements MetaObjectHandler {

    /** 数据库int类型字段默认值 */
    private static final int DEFAULT_DB_INIT_STATUS_VALUE = 0;
    private static final int DEFAULT_DB_INIT_DELETED_VALUE = 0;

    /**
     * 插入记录时填充策略
     *
     * @param metaObject
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        // 根据实际场景获取操作人
        String operator = "Admin";
        this.setFieldValByName("status", DEFAULT_DB_INIT_STATUS_VALUE, metaObject);
        this.setFieldValByName("deleted", DEFAULT_DB_INIT_DELETED_VALUE, metaObject);
        this.setFieldValByName("createTime", new Date(), metaObject);
        this.setFieldValByName("updateTime", new Date(), metaObject);
        this.setFieldValByName("createBy", operator, metaObject);
        this.setFieldValByName("updateBy", operator, metaObject);
    }

    /**
     * 更新记录时填充策略
     * @param metaObject
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        // 根据实际场景获取操作人
        String operator = "Admin";
        this.setFieldValByName("updateTime",new Date(),metaObject);
        this.setFieldValByName("updateBy", new Date(), metaObject);
        this.setFieldValByName("updateBy", operator, metaObject);
    }
}

