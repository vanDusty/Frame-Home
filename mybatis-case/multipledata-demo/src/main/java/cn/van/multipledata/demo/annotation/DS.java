package cn.van.multipledata.demo.annotation;

import cn.van.multipledata.demo.enums.DynamicDSEnum;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * @公众号： 风尘博客
 * @Classname DS
 * @Date 2019/4/14 3:59 下午
 * @Author by Van
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface DS {
    /**
     * 如果没设置数据源，默认 用 master 库
     * @return
     */
    DynamicDSEnum value() default DynamicDSEnum.MASTER;

    boolean clear() default true;
}
