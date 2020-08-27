package cn.van.desensitization.demo.desensitization;

import java.lang.annotation.*;
/**
 * Copyright (C), 2015-2020, 风尘博客
 * 公众号 : 风尘博客
 * FileName: Desensitized
 *
 * @author: Van
 * Date:     2020-08-02 20:49
 * Description: 自定义的脱敏注解
 * Version： V1.0
 */
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Desensitized {
    //    脱敏类型(规则)
    SensitiveTypeEnum type();
}
