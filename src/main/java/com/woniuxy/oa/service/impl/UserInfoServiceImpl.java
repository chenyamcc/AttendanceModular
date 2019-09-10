package com.woniuxy.oa.service.impl;

import com.woniuxy.oa.enums.ExceptionEnum;
import com.woniuxy.oa.exception.UserException;
import com.woniuxy.oa.mapper.UserInfoMapper;
import com.woniuxy.oa.service.UserInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @program: WoniuOA
 * @description:
 * @author: Carl
 * @create: 2019-09-05 11:21
 **/
@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Resource
    private UserInfoMapper userInfoMapper;
    @Override
    public Map<String,Object> queryUserInfoByUid(Integer uid) {
        if (uid ==null){
            throw new UserException(ExceptionEnum.UID_REQUIRE);
        }
        Map<String,Object> map = userInfoMapper.selectUserInfoByUid(uid);
        if (map == null) {
            throw new UserException(ExceptionEnum.USER_INFO_NOT_FIND);
        }
        return map;
    }
}
