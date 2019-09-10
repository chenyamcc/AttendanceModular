package com.woniuxy.oa.entity;

public class SchedulePlan {
	private int spid;
	private String starttime;
	private String endtime;
	private String transacationtype;
	private String content;
	private int falg;
	private int atid;
	private int asid;
	private int uid;
	private int pid;
	@Override
	public String toString() {
		return "SchedulePlan [spid=" + spid + ", starttime=" + starttime + ", endtime=" + endtime
				+ ", transacationtype=" + transacationtype + ", content=" + content + ", falg=" + falg + ", atid="
				+ atid + ", asid=" + asid + ", uid=" + uid + ", pid=" + pid + "]";
	}
	public SchedulePlan() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getSpid() {
		return spid;
	}
	public void setSpid(int spid) {
		this.spid = spid;
	}
	public String getStarttime() {
		return starttime;
	}
	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}
	public String getEndtime() {
		return endtime;
	}
	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}
	public String getTransacationtype() {
		return transacationtype;
	}
	public void setTransacationtype(String transacationtype) {
		this.transacationtype = transacationtype;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getFalg() {
		return falg;
	}
	public void setFalg(int falg) {
		this.falg = falg;
	}
	public int getAtid() {
		return atid;
	}
	public void setAtid(int atid) {
		this.atid = atid;
	}
	public int getAsid() {
		return asid;
	}
	public void setAsid(int asid) {
		this.asid = asid;
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
	public SchedulePlan(int spid, String starttime, String endtime, String transacationtype, String content, int falg,
			int atid, int asid, int uid, int pid) {
		super();
		this.spid = spid;
		this.starttime = starttime;
		this.endtime = endtime;
		this.transacationtype = transacationtype;
		this.content = content;
		this.falg = falg;
		this.atid = atid;
		this.asid = asid;
		this.uid = uid;
		this.pid = pid;
	}
	
}
