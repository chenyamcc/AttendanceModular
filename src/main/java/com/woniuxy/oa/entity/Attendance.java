package com.woniuxy.oa.entity;


import java.util.Date;

/**
 * 考勤表po
 * aid：考勤表编号
 * uid：用户表id
 * begintime：签到时间
 * endtime：签退时间
 * uname:用户姓名
 * @author 廖天驰
 *
 */
public class Attendance {
	private int aid;
	private int uid;
	private Date begintime;
	private Date endtime;
	private String uname;
	private String day;
	
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
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
	
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	
	
	public Attendance(int aid, int uid, Date begintime, Date endtime, String uname, String day) {
		super();
		this.aid = aid;
		this.uid = uid;
		this.begintime = begintime;
		this.endtime = endtime;
		this.uname = uname;
		this.day = day;
	}
	public Attendance() {
		
	}
	@Override
	public String toString() {
		return "Attendance [aid=" + aid + ", uid=" + uid + ", begintime=" + begintime + ", endtime=" + endtime
				+ ", uname=" + uname + ", day=" + day + "]";
	}
	
	
	

}
