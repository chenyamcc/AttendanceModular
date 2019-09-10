package com.woniuxy.oa.mapper;

import com.woniuxy.oa.entity.UserAddress;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
* @program: WoniuOA
*
* @description: ${description}
*
* @author: Carl
*
* @create: 2019-09-06 10:01
**/

public interface UserAddressMapper {
    int deleteByPrimaryKey(Integer uaid);

    int insert(UserAddress record);

    int insertSelective(UserAddress record);

    UserAddress selectByPrimaryKey(Integer uaid);

    int updateByPrimaryKeySelective(UserAddress record);

    int updateByPrimaryKey(UserAddress record);

    List<Map<String, Object>> queryUserAddressList(@Param("name") String name);
}