package cn.van.mybatis.batch.mapper;

import cn.van.mybatis.batch.entity.UserInfoBatchDO;

import java.util.List;

public interface UserInfoBatchMapper {

    /** 单条插入
     * @param info
     * @return
     */
    int insert(UserInfoBatchDO info);

    /**
     * foreach 插入
     * @param list
     * @return
     */
    int batchInsert(List<UserInfoBatchDO> list);
}