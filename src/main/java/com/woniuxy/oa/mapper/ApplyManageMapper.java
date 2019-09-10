package com.woniuxy.oa.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.woniuxy.oa.entity.ApplyManage;
@Mapper
public interface ApplyManageMapper {
	/**
	 * 查询所有申领信息
	 * @return
	 */
	List<ApplyManage>selectAllApplyManages();
	/**
	 * 添加申领信息
	 * @param applyManage
	 */
	void insertApplyManage(ApplyManage applyManage);
	/**
	 * 更新申领信息
	 * @param applyManage
	 */
	void updateApplyManage(ApplyManage applyManage);
	/**
	 * 删除申领信息
	 * @param amid
	 */
	void deleteApplyManage(int amid);
	/**
	 * 根据id查询申领信息
	 * @param amid
	 * @return
	 */
	ApplyManage selectApplyManageByamid(int amid);
	
	/**
	 *  根据查询条件模糊查询用户信息
	 * @param applyManage
	 * @param pageIndex
	 * @param pageSize
	 * @param rid
	 * @return
	 */
	List<ApplyManage> selectAllApplyManagesByCondition(@Param("applyManage")ApplyManage applyManage
			,@Param("pageIndex") int pageIndex ,@Param("pageSize") int pageSize,@Param("rid") int rid);
	
	/**
	 * 根据条件查询总的信息条数
	 * @param applyManage
	 * @param rid
	 * @return
	 */
	int selectCountsByCondition(@Param("applyManage")ApplyManage applyManage,@Param("rid") int rid);
	
	
	/**
	 * 根据amid修改该用户的审批状态码asid
	 * @param amid
	 * @param asid
	 */
	void updateApplyManageAsidByAmid(int amid,int asid);
	
}
