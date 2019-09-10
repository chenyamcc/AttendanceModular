package com.woniuxy.oa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniuxy.oa.entity.PageIngBean;
import com.woniuxy.oa.entity.User;
import com.woniuxy.oa.entity.WorkTask;
import com.woniuxy.oa.mapper.WorkTaskMapper;
import com.woniuxy.oa.service.WorkTaskService;
/**
 * WorkTask业务逻辑-(实现类)
 * @author Administrator
 *
 */
@Service("workTaskService")
public class WorkTaskServiceImp implements WorkTaskService {
	
	//创建WorkTaskMapper对象
	@Autowired
	WorkTaskMapper workTaskMapper;
	/**
	 * 装配PageInfo将数据传入前端
	 * @param pageIndex
	 * @param PageSize
	 * @param user
	 * @return
	 */
	@Override
	public PageInfo<WorkTask> workTaskPage(int pageIndex, int pageSize, User user) {
		PageHelper.startPage(pageIndex, pageSize);
		//调用查询所有数据的方法
		List<WorkTask> workTaks = workTaskMapper.selectWorkTaskAllByUname(user);
		PageInfo<WorkTask> pb= new PageInfo<>(workTaks);
		return pb;
	}
	
	/**
	 * 删除数据(根据创建来的wid删除整行数据)
	 */
	@Override
	public void deleteworkTask(int wtid) {
		workTaskMapper.deleteWoekTaskOne(wtid);
	}
	/**
	 * 查找所有人的姓名
	 */
	@Override
	public List<User> selectUnameAll() {
		List<User> users = workTaskMapper.findAllUname();
		return users;
	}
	/**
	 * 添加工作计划
	 */
	@Override
	public void insertWorkTask(WorkTask workTask) {
		workTaskMapper.addWorkTask(workTask);
	}
	/**
	 * 修改工作计划
	 */
	@Override
	public void updatWorkTask(WorkTask workTask) {
		workTaskMapper.updateWorkTaskOne(workTask);
	}


}
