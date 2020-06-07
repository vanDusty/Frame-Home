/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: DBEnum
 * Author:   zhangfan
 * Date:     2019-06-14 17:02
 * Description: 数据库枚举类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package cn.van.multipledata.demo.enums;

/**
 * 〈〉<br>
 * 〈数据库枚举类〉
 *
 * @author zhangfan
 * @create 2019-06-14
 * @since 1.0.0
 */
public enum DynamicDSEnum {
    MASTER(1,"master"),
    SLAVE(2,"slave"),

    ;

    DynamicDSEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }
    private Integer code;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    private String desc;

}