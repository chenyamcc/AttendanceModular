package com.woniuxy.oa.entity;

import java.util.Date;

/**
 * 加班表
 * oid：加班编号
 * uid：用户编号
 * atid：applytype id--申请类型id
 * applytime：申请时间
 * begintime：加班开始时间
 * endtime：加班结束时间
 * overtime：加班时长
 * describe：加班描述
 * asid：applystatement--申请状态
 * @author Administrator
 *
 */
public class OverTime {
	private int oid;
	private int uid;
	private int atid;
	private String  applytime;
	private Date begintime;
	private Date endtime;
	private String  overtime;
	private String edescribe;
	private String  asname;
	private String uname;
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	
	
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getAtid() {
		return atid;
	}
	public void setAtid(int atid) {
		this.atid = atid;
	}
	public String  getApplytime() {
		return applytime;
	}
	public void setApplytime(String applytime) {
		this.applytime = applytime;
	}
	public Date getBegintime() {
		return begintime;
	}
	public void setBegintime(Date begintime) {
		this.begintime = begintime;
	}
	public Date getEndtime() {
		return endtime;
	}
	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}
	public String  getOvertime() {
		return overtime;
	}
	public void setOvertime(String  overtime) {
		this.overtime = overtime;
	}
	
	public String getEdescribe() {
		return edescribe;
	}
	public void setEdescribe(String edescribe) {
		this.edescribe = edescribe;
	}
	public String getAsname() {
		return asname;
	}
	public void setAsname(String asname) {
		this.asname = asname;
	}
	public OverTime(int oid, int uid, int atid, String applytime, Date begintime, Date endtime, String  overtime,
			String edescribe, String asname) {
		super();
		this.oid = oid;
		this.uid = uid;
		this.atid = atid;
		this.applytime = applytime;
		this.begintime = begintime;
		this.endtime = endtime;
		this.overtime = overtime;
		this.edescribe = edescribe;
		this.asname = asname;
	}
	public OverTime() {
		
	}
	@Override
	public String toString() {
		return "OverTime [oid=" + oid + ", uid=" + uid + ", atid=" + atid + ", applytime=" + applytime + ", begintime="
				+ begintime + ", endtime=" + endtime + ", overtime=" + overtime + ", edescribe=" + edescribe
				+ ", asname=" + asname + "]";
	}
	

}
