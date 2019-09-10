package com.woniuxy.oa.service;

import com.woniuxy.oa.utils.PageResult;

import java.util.Map;

/**
 * @program: WoniuOA
 * @description: 用户备忘录的业务层接口
 * @author: Carl
 * @create: 2019-09-06 09:48
 **/
public interface UserAddressService {
    /**
     * 查询用户备忘录数据集
     * @param name 模糊查询
     * @param pageIndex 当前页码
     * @param rows 每页显示的条数
     * @return map
     */
    PageResult<Map<String, Object>> queryUserAddressList(String name, Integer pageIndex, Integer rows);

}
