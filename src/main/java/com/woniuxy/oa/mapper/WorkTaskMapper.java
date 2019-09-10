package com.woniuxy.oa.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.woniuxy.oa.entity.User;
import com.woniuxy.oa.entity.WorkTask;

/**
 * 工作计划(数据操作层)
 * @author Administrator
 *
 */
public interface WorkTaskMapper {
	/**
	 * <根据姓名模糊查询>工作计划的所有数据
	 * @param user
	 * @return List<WorkTask>
	 */
	List<WorkTask> selectWorkTaskAllByUname(@Param("user") User user);
	/**
	 * 删除数据(根据创建来的wid删除整行数据)
	 * @param wtid
	 */
	void deleteWoekTaskOne(int wtid);
	/**
	 * 查找所有的Uname
	 * @return
	 */
	List<User> findAllUname();
	/**
	 * 添加工作计划
	 * @param workTask
	 */
	void addWorkTask(WorkTask workTask);
	/**
	 * 修改工作计划
	 * @param workTask
	 */
	void updateWorkTaskOne(WorkTask workTask);
}
