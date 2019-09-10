package com.woniuxy.oa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woniuxy.oa.entity.ApplyManage;
import com.woniuxy.oa.entity.PageBean;
import com.woniuxy.oa.mapper.ApplyManageMapper;
import com.woniuxy.oa.mapper.UserMapper;
import com.woniuxy.oa.service.ApplyManageService;
@Service
public class ApplyManageServiceImpl implements ApplyManageService {

	@Autowired
	ApplyManageMapper applyManageMapper;
	@Autowired
	UserMapper userManapper;
	/**
	 * 查询所有申领信息
	 */
	@Override
	public List<ApplyManage> getAllApplyManage() {
		
		return applyManageMapper.selectAllApplyManages();
	}
	/**
	 * 添加申领信息
	 */
	@Override
	public void addApplyManage(ApplyManage applyManage) {
		
		applyManageMapper.insertApplyManage(applyManage);

	}
	/**
	 * 修改申领信息
	 */
	@Override
	public void modifyApplyManage(ApplyManage applyManage) {
		applyManageMapper.updateApplyManage(applyManage);

	}
	/**
	 * 申领信息
	 */
	@Override
	public void deleteApplyManage(int amid) {
		
		applyManageMapper.deleteApplyManage(amid);

	}
	/**
	 * 根据id获取申领信息
	 */
	@Override
	public ApplyManage getApplyManageByamid(int amid) {
		
		return applyManageMapper.selectApplyManageByamid(amid);
	}

	/**
	 * 封装pagebean
	 */
	@Override
	public PageBean<ApplyManage> getAllApplyManageByCondition(ApplyManage applyManage, int pageIndex, int pageSize,int rid) {
		PageBean<ApplyManage> pageBean = new PageBean<ApplyManage>();
		List<ApplyManage> lists=applyManageMapper.selectAllApplyManagesByCondition(applyManage, (pageIndex-1)*10, pageSize,rid);
		int totalNews =applyManageMapper.selectCountsByCondition(applyManage,rid);
		pageBean.setUserNews(lists);
		pageBean.setPageSizes(pageSize);
		pageBean.setTotalNews(totalNews);
		pageBean.setPage(pageIndex);
		pageBean.setpageBeginpageEnd();
		return pageBean;
	}
	
	@Override
	public void modifyApplyManageAsidByAmid(int amid, int asid) {
		applyManageMapper.updateApplyManageAsidByAmid(amid, asid);
		
	}

}
