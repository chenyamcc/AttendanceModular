package com.woniuxy.oa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woniuxy.oa.entity.ApplyManage;
import com.woniuxy.oa.entity.PageBean;
import com.woniuxy.oa.entity.SubscribManage;
import com.woniuxy.oa.mapper.SubscribManageMapper;

@Service
public class SubscribManageServiceImpl implements com.woniuxy.oa.service.SubscribManageService {

	@Autowired
	SubscribManageMapper subScribManageMapper;	
	@Override
	public void addSubscribManage(SubscribManage subscribManage) {
		subScribManageMapper.insertSubscribManage(subscribManage);

	}

	@Override
	public void modifySubscribManage(SubscribManage subscribManage) {
		subScribManageMapper.updateSubscribManage(subscribManage);

	}

	@Override
	public void deleteSubscribManage(int smid) {
		subScribManageMapper.deleteSubscribManageBysmid(smid);

	}

	@Override
	public SubscribManage getSubscribManageBysmid(int smid) {
		
		return subScribManageMapper.selectSubscribManageBysmid(smid);
	}

	@Override
	public PageBean<SubscribManage> getAllSubscribManageByCondition(SubscribManage subscribManage, int pageIndex,
			int pageSize,int rid) {
		PageBean<SubscribManage> pageBean = new PageBean<SubscribManage>();
		List<SubscribManage> lists=subScribManageMapper.seleteSubscribManageByCondition(subscribManage, (pageIndex-1)*10, pageSize,rid);
		int totalNews =subScribManageMapper.selectCountsByCondition(subscribManage,rid);
		pageBean.setUserNews(lists);
		pageBean.setPageSizes(pageSize);
		pageBean.setTotalNews(totalNews);
		pageBean.setPage(pageIndex);
		pageBean.setpageBeginpageEnd();
		return pageBean;
	}

	@Override
	public void modifySubscribManagesAsidBySmid(int smid, int asid) {
		subScribManageMapper.updateSubscribManagesAsidBySmid(smid, asid);		
	}

}
