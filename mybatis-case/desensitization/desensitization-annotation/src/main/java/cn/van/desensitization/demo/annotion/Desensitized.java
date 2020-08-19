package cn.van.desensitization.demo.annotion;

import cn.van.desensitization.demo.entity.SensitiveTypeEnum;

import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Desensitized {
    //    脱敏类型(规则)
    SensitiveTypeEnum type();
}
