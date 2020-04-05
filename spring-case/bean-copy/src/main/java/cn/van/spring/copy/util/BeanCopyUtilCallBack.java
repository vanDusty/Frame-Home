package cn.van.spring.copy.util;

/**
 * Copyright (C), 2015-2020, 风尘博客
 * 公众号 : 风尘博客
 * FileName: BeanCopyUtilCallBack
 *
 * @author: Van
 * Date:     2020-01-01 11:28
 * Description: 函数式接口
 * Version： V1.0
 */
@FunctionalInterface
public interface BeanCopyUtilCallBack <S, T> {

    /**
     * 定义默认回调方法
     * @param s: 数据源类 ，
     * @param t: 目标类
     */
    void callBack(S s, T t);
}
