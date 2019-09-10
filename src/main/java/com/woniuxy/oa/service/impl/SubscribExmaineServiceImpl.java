package com.woniuxy.oa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woniuxy.oa.entity.PageBean;
import com.woniuxy.oa.entity.SubscribManage;
import com.woniuxy.oa.mapper.SubscribManageMapper;
import com.woniuxy.oa.service.SubscribExamineService;
import com.woniuxy.oa.service.SubscribManageService;
@Service
public class SubscribExmaineServiceImpl implements SubscribExamineService {

	@Autowired	
	SubscribManageMapper subscribManageMapper;
	@Override
	public List<SubscribManage> getAllSubscribManage() {

		return subscribManageMapper.selectAllSubscribManages();
	}

	
}
