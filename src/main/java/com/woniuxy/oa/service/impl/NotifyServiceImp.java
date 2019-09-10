package com.woniuxy.oa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woniuxy.oa.entity.Notify;
import com.woniuxy.oa.entity.User;
import com.woniuxy.oa.mapper.NotifyMapper;
import com.woniuxy.oa.service.NotifyService;

@Service
public class NotifyServiceImp implements NotifyService {
	
	@Autowired
	NotifyMapper notifyMapper;

	@Override
	public List<User> findAllUsers() {
		List<User> users = notifyMapper.selectAllUsers();
		return users;
	}

	@Override
	public void insertNotify(String title, String content, String edescribe, String filepath, String filename, int receiverid,int senderid) {
		notifyMapper.insertNotify(title, content, edescribe, filepath, filename, receiverid, senderid);		
	}

	@Override
	public List<Notify> findMyReciveNotifys(int uid) {
		List<Notify> myReciveNotifys = notifyMapper.selectMyReciveNotifys(uid);
		return myReciveNotifys;
	}

	@Override
	public List<Notify> findMySendNotifys(int uid) {
		List<Notify> mySendNotifys = notifyMapper.selectMySendNotifys(uid);
		return mySendNotifys;
	}

	@Override
	public String findUnameByUid(int uid) {
		String uname = notifyMapper.selectUnameByUid(uid);
		return uname;
	}

	@Override
	public Notify findNotifyById(int id) {
		Notify notify = notifyMapper.selectNotifyById(id);
		return notify;
	}

	@Override
	public int findselectReceiveridByRealname(String recipinet) {
		int receiverid = notifyMapper.selectReceiveridByRealname(recipinet);
		return receiverid;
	}

	@Override
	public int findSenderidByRecipinet(String realName) {
		int senderid = notifyMapper.selectSenderidByRecipinet(realName);
		return senderid;
	}

	@Override
	public void modifyNotifyById(String title, String content, String filepath, String filename, int receiverid,
			int senderid, int id) {
		notifyMapper.updateNotifyById(title, content, filepath, filename, receiverid, senderid, id);
	}

	@Override
	public List<Notify> findUncheckedNotifys() {
		List<Notify> uncheckedNotifys = notifyMapper.selectUncheckedNotifys();
		return uncheckedNotifys;
	}

	@Override
	public void modifyNotifyStateById(int asid, int id) {
		notifyMapper.updateNotifyStateById(asid, id);
	}

	@Override
	public void recallNotifyById(int id) {
		notifyMapper.deleteNotifyById(id);
	}

}
