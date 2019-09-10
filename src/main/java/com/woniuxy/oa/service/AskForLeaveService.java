package com.woniuxy.oa.service;

import java.util.List;

import com.woniuxy.oa.entity.AskForLeave;
import com.woniuxy.oa.entity.PageBeaning;
import com.woniuxy.oa.entity.User;

public interface AskForLeaveService {

	public PageBeaning<AskForLeave> getAskForLeaveByPage(int pageIndex,int pageSize, AskForLeave askForLeave);

	public boolean deleteAskForLeave(int alid);

	public List<User> selectUsers();

	public void insertLeave(AskForLeave askForLeave);

	public int selectUid(String uname);

	public AskForLeave selectOneLevae(int alid);

	public void updateLevae(AskForLeave askForLeave);
	
}
