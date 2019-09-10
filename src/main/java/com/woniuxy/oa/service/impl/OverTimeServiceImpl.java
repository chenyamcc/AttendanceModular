package com.woniuxy.oa.service.impl;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woniuxy.oa.entity.OverTime;
import com.woniuxy.oa.entity.User;
import com.woniuxy.oa.mapper.OverTimeMapper;
import com.woniuxy.oa.service.OverTimeService;
@Service
public class OverTimeServiceImpl implements OverTimeService{
	@Autowired
	OverTimeMapper overtimeMapper;

	@Override
	public int  insert(User user,OverTime overtime) {
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		overtime.setUid(user.getUid());
		overtime.setUname(user.getUname());
		overtime.setApplytime(format.format(date));
		overtime.setOvertime(computer(overtime.getBegintime(),overtime.getEndtime()));
		return overtimeMapper.insert(overtime);
		
	}

	@Override
	public int update(OverTime overtime) {
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		overtime.setApplytime(format.format(date));
		overtime.setOvertime(computer(overtime.getBegintime(),overtime.getEndtime()));
		return overtimeMapper.update(overtime);
		
	}

	@Override
	public List<OverTime> selectSelf(User user,OverTime overtime) {
		overtime.setUid(user.getUid());
		return overtimeMapper.selectSelf(overtime);
	}

	@Override
	public List<OverTime> selectAll(User user, OverTime overtime) {
		
		return overtimeMapper.selectAll(user.getDid(),overtime);
	}
	
	@Override
	public int delete(int oid) {
		// TODO Auto-generated method stub
		return overtimeMapper.delete(oid);
	}
	
	
	
	private String computer(Date d1,Date d2) {
		float result=(d2.getTime()-d1.getTime())/1000/60/60;
		DecimalFormat de=new DecimalFormat("#.#");
		return de.format(result)+"小时";
	}

	

}
