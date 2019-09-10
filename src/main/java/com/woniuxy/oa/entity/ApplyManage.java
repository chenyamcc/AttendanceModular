package com.woniuxy.oa.entity;

import java.util.Date;
/**
 * amid:申领管理id
 * uname:申领姓名
 * goods：申领物品
 * applytime：申领时间
 * uid：用户id
 * pid：权限id
 * asid：审批状态id
 * atid：审批类型id
 * flag:软删除
 * asname:权限类型
 * rid:角色id
 * edescribe:审批描述
 * @author 袁野
 *
 */
public class ApplyManage {
	private Integer amid;
	private String uname;
	private String goods;
	private Date applytime;
	private Integer uid;
	private Integer pid;
	private int asid;
	private int atid;
	private int flag;
	private String asname;
	private int rid;
	private String edescribe;
	@Override
	public String toString() {
		return "ApplyManage [amid=" + amid + ", uname=" + uname + ", goods=" + goods + ", applytime=" + applytime
				+ ", uid=" + uid + ", pid=" + pid + ", asid=" + asid + ", atid=" + atid + ", flag=" + flag + ", asname="
				+ asname + ", rid=" + rid + ", edescribe=" + edescribe + "]";
	}
	public ApplyManage() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getAmid() {
		return amid;
	}
	public void setAmid(Integer amid) {
		this.amid = amid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getGoods() {
		return goods;
	}
	public void setGoods(String goods) {
		this.goods = goods;
	}
	public Date getApplytime() {
		return applytime;
	}
	public void setApplytime(Date applytime) {
		this.applytime = applytime;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
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
	public String getAsname() {
		return asname;
	}
	public void setAsname(String asname) {
		this.asname = asname;
	}
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public String getEdescribe() {
		return edescribe;
	}
	public void setEdescribe(String edescribe) {
		this.edescribe = edescribe;
	}
	public ApplyManage(Integer amid, String uname, String goods, Date applytime, Integer uid, Integer pid, int asid,
			int atid, int flag, String asname, int rid, String edescribe) {
		super();
		this.amid = amid;
		this.uname = uname;
		this.goods = goods;
		this.applytime = applytime;
		this.uid = uid;
		this.pid = pid;
		this.asid = asid;
		this.atid = atid;
		this.flag = flag;
		this.asname = asname;
		this.rid = rid;
		this.edescribe = edescribe;
	}
	
	
	
	
}
