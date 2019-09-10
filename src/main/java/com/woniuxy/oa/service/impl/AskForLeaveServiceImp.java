package com.woniuxy.oa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.woniuxy.oa.entity.AskForLeave;
import com.woniuxy.oa.entity.PageBeaning;
import com.woniuxy.oa.entity.User;
import com.woniuxy.oa.mapper.AskForLeaveMapper;
import com.woniuxy.oa.service.AskForLeaveService;

@Service("askForLeaveService")
public class AskForLeaveServiceImp implements AskForLeaveService{

	@Autowired
	@Qualifier("askForLeaveMapper")
	AskForLeaveMapper askForLeaveMapper;
	
	public void setAskForLeaveMapper(AskForLeaveMapper askForLeaveMapper) {
		this.askForLeaveMapper = askForLeaveMapper;
	}
	
	//查询所有数据
	@Override
	public PageBeaning<AskForLeave> getAskForLeaveByPage(int pageIndex, int pageSize, AskForLeave askForLeave) {
		//查询总条数
		int totalRecored=askForLeaveMapper.selectTotalRecored(askForLeave);
		int index=(pageIndex-1)*pageSize;
		int limit=pageSize;
		List<AskForLeave> askForLeaves=askForLeaveMapper.selectAskForLeaveByAll(index,limit,askForLeave);		
		PageBeaning<AskForLeave> pageBean=new PageBeaning<AskForLeave>();
		//组装pageBean
		pageBean.setBeanList(askForLeaves);
		pageBean.setPageIndex(pageIndex);
		pageBean.setPageSize(pageSize);
		pageBean.setTotalRecored(totalRecored);
		pageBean.setPageBeginAndPageEnd();
		return pageBean;
	}

	//删除一条数据
	@Override
	public boolean deleteAskForLeave(int alid) {
		System.out.println("删除数据servcice---"+alid);
		boolean resutl=askForLeaveMapper.deleteAskForLeaveById(alid);
		if(resutl) {
			return true;
		}
		return false;
	}
	
	//添加请假条，查询用户
	@Override
	public List<User> selectUsers() {
		List<User> users=askForLeaveMapper.selectAllUsers();
		return users;
	}

	//添加请假条
	@Override
	public void insertLeave(AskForLeave askForLeave) {
		askForLeaveMapper.insertAskForLeave(askForLeave);
	}

	//查询员工id
	@Override
	public int selectUid(String uname) {
		int uid=askForLeaveMapper.selectUidByUname(uname);
		return uid;
	}

	@Override
	public AskForLeave selectOneLevae(int alid) {
		AskForLeave askForLeave=askForLeaveMapper.selectLeaveByAlid(alid);
		return askForLeave;
	}

	@Override
	public void updateLevae(AskForLeave askForLeave) {
		askForLeaveMapper.updateOneLeave(askForLeave);
	}


	
}
