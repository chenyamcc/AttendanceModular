package com.woniuxy.oa.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniuxy.oa.enums.ExceptionEnum;
import com.woniuxy.oa.exception.UserException;
import com.woniuxy.oa.mapper.UserAddressMapper;
import com.woniuxy.oa.service.UserAddressService;
import com.woniuxy.oa.utils.PageResult;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @program: WoniuOA
 * @description:
 * @author: Carl
 * @create: 2019-09-06 09:48
 **/
@Service
public class UserAddressServiceImpl implements UserAddressService {
    @Resource
    private UserAddressMapper userAddressMapper;
    @Override
    public PageResult<Map<String, Object>> queryUserAddressList(String name, Integer pageIndex, Integer rows) {
        PageHelper.startPage(pageIndex,rows);
        List<Map<String,Object>> addressList = userAddressMapper.queryUserAddressList(name);
        if (CollectionUtils.isEmpty(addressList)){
            throw new UserException(ExceptionEnum.USER_ADDRESS_NOT_FIND);
        }
        PageInfo<Map<String,Object>> pageInfo = new PageInfo<>(addressList);
        PageResult<Map<String, Object>> pageResult = new PageResult<>();
        pageResult.setPageIndex(pageIndex);
        pageResult.setRows(rows);
        pageResult.setDataCount(pageInfo.getTotal());
        pageResult.setPageCount((int) (pageInfo.getTotal()%rows ==0?pageInfo.getTotal()/rows:pageInfo.getTotal()/rows+1));
        pageResult.setList(addressList);
        return pageResult;
    }
}
