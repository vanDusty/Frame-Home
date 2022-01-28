package cn.van.mybatis.plus.common.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
/**
 * Copyright (C), 2015-2022, 风尘博客
 * 公众号 : 风尘博客
 * @Author:   Van
 * Date:     2022/1/6 11:49 下午
 * Description:
 * Version： V1.0
 */
@Data
@TableName("mybatis_plus_meta_fill")
public class MetaFillDO extends BaseEntIty{

    @TableId
    private Long id;

}