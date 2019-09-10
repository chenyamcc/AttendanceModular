package com.woniuxy.oa.service;

import java.util.List;

import com.woniuxy.oa.entity.OverTime;
import com.woniuxy.oa.entity.User;

public interface OverTimeService {
	public int insert(User user,OverTime overtimr);
	public int update(OverTime overtime);
	public List<OverTime> selectSelf(User user,OverTime overtime);
	public List<OverTime> selectAll(User user,OverTime overtime);
	public int delete(int oid);
	

}
