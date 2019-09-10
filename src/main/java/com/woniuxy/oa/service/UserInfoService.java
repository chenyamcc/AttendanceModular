package com.woniuxy.oa.service;

import java.util.Map;

/**
 * @program: WoniuOA
 * @description: 用户详情接口
 * @author: Carl
 * @create: 2019-09-05 11:20
 **/
public interface UserInfoService {
    /**
     * 根据用户的id查询用户的详情
     * @param uid 用户的id也是详情表的id
     * @return 用户的详情数据
     */
    Map<String,Object> queryUserInfoByUid(Integer uid);
}
