package com.woniuxy.oa.entity;

import java.text.DateFormat;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Schedule {

	private int sid;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date datebegin;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateend;
	private String transactiontype;
	private String schedulecontent;
	private int flag;
	private int uid;
	private String uname;
	public Schedule() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public Date getDatebegin() {
		return datebegin;
	}
	public void setDatebegin(Date datebegin) {
		this.datebegin = datebegin;
	}
	public Date getDateend() {
		return dateend;
	}
	public void setDateend(Date dateend) {
		this.dateend = dateend;
	}
	public String getTransactiontype() {
		return transactiontype;
	}
	public void setTransactiontype(String transactiontype) {
		this.transactiontype = transactiontype;
	}
	public String getSchedulecontent() {
		return schedulecontent;
	}
	public void setSchedulecontent(String schedulecontent) {
		this.schedulecontent = schedulecontent;
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
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public Schedule(int sid, Date datebegin, Date dateend, String transactiontype, String schedulecontent, int flag,
			int uid, String uname) {
		super();
		this.sid = sid;
		this.datebegin = datebegin;
		this.dateend = dateend;
		this.transactiontype = transactiontype;
		this.schedulecontent = schedulecontent;
		this.flag = flag;
		this.uid = uid;
		this.uname = uname;
	}
	@Override
	public String toString() {
		return "Schedule [sid=" + sid + ", datebegin=" + datebegin + ", dateend=" + dateend + ", transactiontype="
				+ transactiontype + ", schedulecontent=" + schedulecontent + ", flag=" + flag + ", uid=" + uid
				+ ", uname=" + uname + "]";
	}
	
}
