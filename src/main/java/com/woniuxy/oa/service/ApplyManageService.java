package com.woniuxy.oa.service;

import java.util.List;

import com.woniuxy.oa.entity.ApplyManage;
import com.woniuxy.oa.entity.PageBean;

public interface ApplyManageService {
	/**
	 * 查询所有申领信息
	 * @return
	 */
	List<ApplyManage> getAllApplyManage();
	/**
	 * 添加申领信息
	 * @param applyManage
	 */
	void addApplyManage(ApplyManage applyManage);
	/**
	 * 修改申领信息
	 * @param applyManage
	 */
	void modifyApplyManage(ApplyManage applyManage);
	/**
	 * 根据id删除申领信息
	 * @param amid
	 */
	void deleteApplyManage(int amid);
	/**
	 * 根据id获取申领信息
	 * @param amid
	 * @return
	 */
	ApplyManage getApplyManageByamid(int amid);
	/**
	 * 根据条件查询pagebean
	 * @param applyManage
	 * @param pageIndex
	 * @param pageSize
	 * @param rid
	 * @return
	 */
	PageBean<ApplyManage> getAllApplyManageByCondition(ApplyManage applyManage,int pageIndex,int pageSize,int rid);
	
	/**
	 * 根据id修改申领管理信息的审批状态
	 * @param smid
	 * @param asid
	 */
	void modifyApplyManageAsidByAmid(int amid,int asid);
}
