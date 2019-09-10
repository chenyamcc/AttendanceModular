package com.woniuxy.oa.mapper;

import java.util.List;

import com.woniuxy.oa.entity.Notify;
import com.woniuxy.oa.entity.User;

public interface NotifyMapper {
	List<User> selectAllUsers();

	void insertNotify(String title, String content, String edescribe, String filepath, String filename, int receiverid, int senderid);

	List<Notify> selectMyReciveNotifys(int uid);

	List<Notify> selectMySendNotifys(int uid);

	String selectUnameByUid(int uid);

	Notify selectNotifyById(int id);

	int selectReceiveridByRealname(String recipinet);

	int selectSenderidByRecipinet(String realName);

	void updateNotifyById(String title, String content, String filepath, String filename, int receiverid, int senderid, int id);
	
	void deleteNotifyById(int id);
	
	List<Notify> selectUncheckedNotifys();
	
	void updateNotifyStateById(int asid, int id);
}
