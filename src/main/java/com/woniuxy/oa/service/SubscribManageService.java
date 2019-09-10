package com.woniuxy.oa.service;

import java.util.List;

import com.woniuxy.oa.entity.ApplyManage;
import com.woniuxy.oa.entity.PageBean;
import com.woniuxy.oa.entity.SubscribManage;

public interface SubscribManageService {
	/**
	 * 添加申领管理信息
	 * @param subscribManage
	 */
	void addSubscribManage(SubscribManage subscribManage);
	/**
	 * 修改申领管理信息
	 * @param subscribManage
	 */
	void modifySubscribManage(SubscribManage subscribManage);
	/**
	 * 根据id删除申领管理信息
	 * @param smid
	 */
	void deleteSubscribManage(int smid);
	/**
	 * 根据id查询申领管理信息
	 * @param smid
	 * @return
	 */
	SubscribManage getSubscribManageBysmid(int smid);
	/**
	 * 根据id和其他关键信息模糊查询申领管理信息
	 * @param subscribManage
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	PageBean<SubscribManage> getAllSubscribManageByCondition(SubscribManage subscribManage,int pageIndex,int pageSize,int rid);
	/**
	 * 根据id修改申领管理信息的审批状态
	 * @param smid
	 * @param asid
	 */
	void modifySubscribManagesAsidBySmid(int smid,int asid);
}
