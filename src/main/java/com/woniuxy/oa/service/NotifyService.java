package com.woniuxy.oa.service;

import java.util.List;

import com.woniuxy.oa.entity.Notify;
import com.woniuxy.oa.entity.User;

public interface NotifyService {
	List<User> findAllUsers();

	void insertNotify(String title, String content, String edescribe, String filepath, String filename, int receiverid, int senderid);
	
	List<Notify> findMyReciveNotifys(int uid);
	
	List<Notify> findMySendNotifys(int uid);
	
	String findUnameByUid(int uid);
	
	Notify findNotifyById(int id);
	
	int findselectReceiveridByRealname(String recipinet);
	
	int findSenderidByRecipinet(String realName);
	
	void modifyNotifyById(String title, String content, String filepath, String filename, int receiverid, int senderid, int id);
	
	void recallNotifyById(int id);
	
	List<Notify> findUncheckedNotifys();
	
	void modifyNotifyStateById(int asid, int id);
	
	
}
