package com.van.dusty.dao;

import com.van.dusty.model.UserIdListDO;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserIdListDAO {

    int deleteByPrimaryKey(Long id);

    int insert(UserIdListDO record);

    int insertSelective(UserIdListDO record);


    UserIdListDO selectByPrimaryKey(Long id);


    int updateByPrimaryKeySelective(UserIdListDO record);

    int updateByPrimaryKey(UserIdListDO record);
}