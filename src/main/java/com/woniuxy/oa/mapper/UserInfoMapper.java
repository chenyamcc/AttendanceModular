package com.woniuxy.oa.mapper;

import com.woniuxy.oa.entity.UserInfo;

import java.util.Map;

/**
 * @program: WoniuOA
 * @description: ${description}
 * @author: Carl
 * @create: 2019-09-05 10:09
 **/

public interface UserInfoMapper {
    int deleteByPrimaryKey(Integer uiid);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    UserInfo selectByPrimaryKey(Integer uiid);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);

    Map<String, Object> selectUserInfoByUid(Integer uid);
}