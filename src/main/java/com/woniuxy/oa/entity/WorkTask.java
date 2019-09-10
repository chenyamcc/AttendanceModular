package com.woniuxy.oa.entity;

import java.io.Serializable;

/**
 * WorkTask(工作计划类)
 * @author Administrator
 *
 */
public class WorkTask implements Serializable{
	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 1L;
	private Integer wtid;//工作计划ID
	private String statime;//工作开始时间
	private String endtime;//工作结束时间
	private String problem;//遇到的问题
	private String nextplan;//下周计划
	private Integer uid;//用户ID
	private Integer pid;//权限ID
	private Integer flag;//软删除
	private String uname;//用户姓名
	public WorkTask() {
		super();
		// TODO Auto-generated constructor stub
	}
	public WorkTask(Integer wtid, String statime, String endtime, String problem, String nextplan, Integer uid,
			Integer pid, Integer flag, String uname) {
		super();
		this.wtid = wtid;
		this.statime = statime;
		this.endtime = endtime;
		this.problem = problem;
		this.nextplan = nextplan;
		this.uid = uid;
		this.pid = pid;
		this.flag = flag;
		this.uname = uname;
	}
	public Integer getWtid() {
		return wtid;
	}
	public void setWtid(Integer wtid) {
		this.wtid = wtid;
	}
	public String getStatime() {
		return statime;
	}
	public void setStatime(String statime) {
		this.statime = statime;
	}
	public String getEndtime() {
		return endtime;
	}
	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}
	public String getProblem() {
		return problem;
	}
	public void setProblem(String problem) {
		this.problem = problem;
	}
	public String getNextplan() {
		return nextplan;
	}
	public void setNextplan(String nextplan) {
		this.nextplan = nextplan;
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
	public Integer getFlag() {
		return flag;
	}
	public void setFlag(Integer flag) {
		this.flag = flag;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	@Override
	public String toString() {
		return "\nWorkTask [wtid=" + wtid + ", statime=" + statime + ", endtime=" + endtime + ", problem=" + problem
				+ ", nextplan=" + nextplan + ", uid=" + uid + ", pid=" + pid + ", flag=" + flag + ", uname=" + uname
				+ "]";
	}
	
	
}
