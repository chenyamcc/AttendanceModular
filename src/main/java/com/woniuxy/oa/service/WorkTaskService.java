package com.woniuxy.oa.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.woniuxy.oa.entity.Expense;
import com.woniuxy.oa.entity.PageIngBean;
import com.woniuxy.oa.entity.User;
import com.woniuxy.oa.entity.WorkTask;

/**
 * WorkTask业务逻辑-(工作计划)
 * @author Administrator
 *
 */
public interface WorkTaskService {
	/**
	 * 装配PageInfo将数据传入前端
	 * @param pageIndex
	 * @param PageSize
	 * @param user
	 * @return
	 */
	PageInfo<WorkTask> workTaskPage(int pageIndex,int pageSize,User user);
	/**
	 * 删除数据(根据创建来的wid删除整行数据)
	 * @param wtid
	 */
	void deleteworkTask(int wtid);
	/**
	 * 查找所有的姓名
	 * @return
	 */
	List<User> selectUnameAll();
	/**
	 * 添加工作计划
	 * @param workTask
	 */
	void insertWorkTask(WorkTask workTask);
	/**
	 * 修改工作计划
	 * @param workTask
	 */
	void updatWorkTask(WorkTask workTask);
	
}
