package com.woniuxy.oa.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.woniuxy.oa.entity.ApplyManage;
import com.woniuxy.oa.entity.SubscribManage;

public interface SubscribManageMapper {
	/**
	 * 模糊查询所有申购信息
	 * @param subscribManage
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	List<SubscribManage> seleteSubscribManageByCondition(@Param("SubscribManage") SubscribManage subscribManage,
					@Param("pageIndex") int pageIndex,@Param("pageSize") int pageSize,@Param("rid") int rid);
	/**
	 * 查询所有条数
	 * @param subscribManage
	 * @return
	 */
	int selectCountsByCondition(@Param("SubscribManage") SubscribManage subscribManage,@Param("rid") int rid);
	
	/**
	 * 删除某个申购信息
	 * @param mbid
	 */
	void deleteSubscribManageBysmid(int smid);

	/**
	 * 修改某个申购信息  
	 * @param subscribManage
	 */
	void updateSubscribManage(SubscribManage subscribManage);
	
	/**
	 * 添加某个申购信息
	 * @param subscribManage
	 */
	void insertSubscribManage(SubscribManage subscribManage);
	/**
	 * 根据smid查申购信息
	 * @param smid
	 * @return
	 */
	SubscribManage selectSubscribManageBysmid(int smid);
	/**
	 * 查询所有信息
	 * @param 
	 * @return
	 */
	List<SubscribManage> selectAllSubscribManages();
	
	/**
	 * 根据smid修改该用户的审批状态码asid
	 * @param smid
	 * @param asid
	 */
	void updateSubscribManagesAsidBySmid(int smid,int asid);
	
	
	
}
