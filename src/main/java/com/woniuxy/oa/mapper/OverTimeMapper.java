package com.woniuxy.oa.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.woniuxy.oa.entity.OverTime;

public interface OverTimeMapper {
	public int insert(OverTime overtime);
	public int update(OverTime overtime);
	public List<OverTime> selectSelf(OverTime overtime);
	public List<OverTime> selectAll(@Param("did")int did,@Param("overtime")OverTime overtime);
	public int delete(int oid);

}
