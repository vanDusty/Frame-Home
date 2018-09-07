package com.van.dusty.common.utils;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @program: Spring-Home
 * @description:
 * @author: Van
 * @create: 2018-09-04 14:53
 **/
public class Underline2CamelUtil {
    public static  final Logger log= LoggerFactory.getLogger(Underline2CamelUtil.class);
    /**
     * 下划线转驼峰法
     * @param line 源字符串
     * @param smallCamel 大小驼峰,是否为小驼峰
     * @return 转换后的字符串
     */
    public static String underline2Camel(String line,boolean smallCamel){
        if(line==null||"".equals(line)){
            return "";
        }
        StringBuffer sb=new StringBuffer();
        Pattern pattern= Pattern.compile("([A-Za-z\\d]+)(_)?");
        Matcher matcher=pattern.matcher(line);
        while(matcher.find()){
            String word=matcher.group();
            sb.append(smallCamel&&matcher.start()==0?Character.toLowerCase(word.charAt(0)):Character.toUpperCase(word.charAt(0)));
            int index=word.lastIndexOf('_');
            if(index>0){
                sb.append(word.substring(1, index).toLowerCase());
            }else{
                sb.append(word.substring(1).toLowerCase());
            }
        }
        return sb.toString();
    }
    /**
     * 驼峰法转下划线
     * @param line 源字符串
     * @return 转换后的字符串
     */
    public static String camel2Underline(String line){
        if(line==null||"".equals(line)){
            return "";
        }
        line=String.valueOf(line.charAt(0)).toUpperCase().concat(line.substring(1));
        StringBuffer sb=new StringBuffer();
        Pattern pattern=Pattern.compile("[A-Z]([a-z\\d]+)?");
        Matcher matcher=pattern.matcher(line);
        while(matcher.find()){
            String word=matcher.group();
            sb.append(word.toLowerCase());
            sb.append(matcher.end()==line.length()?"":"_");
        }
        return sb.toString();
    }

    public static JSONObject camel2UnderlineForObj(Object obj){
        Class<?> clazz = obj.getClass();
        JSONObject json=new JSONObject();
        for(; clazz != Object.class ; clazz = clazz.getSuperclass()) {
            Field[] fields=clazz.getDeclaredFields();
            for(Field field:fields){
                try {
                    field.setAccessible(true); //设置些属性是可以访问的
                    Object val=field.get(obj);
                    if("serialVersionUID".equals(field.getName())){
                        continue;
                    }
                    json.put(camel2Underline(field.getName()), val==null?"":val);
                } catch (IllegalArgumentException e) {
                    log.error("IllegalArgumentException:"+field.getName());
                } catch (IllegalAccessException e) {
                    log.error("IllegalArgumentException:"+field.getName());
                }
            }

        }
        return json;
    }
}
