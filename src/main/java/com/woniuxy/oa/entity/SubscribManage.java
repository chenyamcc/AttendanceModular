package com.woniuxy.oa.entity;

import java.io.Serializable;
import java.util.Date;

public class SubscribManage implements Serializable{

	/**
	 * smid:申购管理id
	 * uname:用户名字
	 * subscribtime：申购时间
	 * goods：申购物品
	 * asid:审批状态
	 * atid:审批类型
	 * flag:软删除
	 * uid:用户id
	 * pid:权限id
	 * edescribe:审批描述
	 * rid:角色rid
	 * asname:权限类型
	 */
	
	
	private static final long serialVersionUID = 1L;
	private int smid;
	private String uname;
	private Date subscribtime;
	private String goods;
	private int asid;
	private int atid;
	private int flag;
	private int uid;
	private int pid;
	private String edescribe;
	private int rid;
	private String asname;
	
	public SubscribManage() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getSmid() {
		return smid;
	}
	public void setSmid(int smid) {
		this.smid = smid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public Date getSubscribtime() {
		return subscribtime;
	}
	public void setSubscribtime(Date subscribtime) {
		this.subscribtime = subscribtime;
	}
	public String getGoods() {
		return goods;
	}
	public void setGoods(String goods) {
		this.goods = goods;
	}
	public int getAsid() {
		return asid;
	}
	public void setAsid(int asid) {
		this.asid = asid;
	}
	public int getAtid() {
		return atid;
	}
	public void setAtid(int atid) {
		this.atid = atid;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getEdescribe() {
		return edescribe;
	}
	public void setEdescribe(String edescribe) {
		this.edescribe = edescribe;
	}
	@Override
	public String toString() {
		return "SubscribManage [smid=" + smid + ", uname=" + uname + ", subscribtime=" + subscribtime + ", goods="
				+ goods + ", asid=" + asid + ", atid=" + atid + ", flag=" + flag + ", uid=" + uid + ", pid=" + pid
				+ ", edescribe=" + edescribe + ", rid=" + rid + ", asname=" + asname + "]";
	}
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public String getAsname() {
		return asname;
	}
	public void setAsname(String asname) {
		this.asname = asname;
	}
	public SubscribManage(int smid, String uname, Date subscribtime, String goods, int asid, int atid, int flag,
			int uid, int pid, String edescribe, int rid, String asname) {
		super();
		this.smid = smid;
		this.uname = uname;
		this.subscribtime = subscribtime;
		this.goods = goods;
		this.asid = asid;
		this.atid = atid;
		this.flag = flag;
		this.uid = uid;
		this.pid = pid;
		this.edescribe = edescribe;
		this.rid = rid;
		this.asname = asname;
	}
	
	
	
	
	
	
}
