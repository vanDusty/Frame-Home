/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: TestService
 * Author:   zhangfan
 * Date:     2019-04-25 10:42
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package cn.van.mybatis.multipledata.simple.service;

import cn.van.mybatis.multipledata.simple.entity.UserInfo;

/**
 * Copyright (C), 2015-2019, 风尘博客
 * 公众号 : 风尘博客
 * FileName: TestService
 * @author: Van
 * Date:     2019-03-26 15:09
 * Description: 测试接口
 * Version： V1.0
 */
public interface TestService {
    // 插入主库
    void insertMater(UserInfo userInfo);
    // 插入从库
    void insertSlave(UserInfo userInfo);
}