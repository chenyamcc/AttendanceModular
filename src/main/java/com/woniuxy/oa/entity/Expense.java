package com.woniuxy.oa.entity;

import java.io.Serializable;

/**
 * Ecpese类(报销管理表)
 * @author 张峻溢
 *
 */
public class Expense implements Serializable{

	private Integer exid;//报销表ID
	private String exname;//报销项目名称
	private String unit;//计价单位
	private Double exmoney;//报销项目单价
	private Integer uid;//账户ID
	private Integer asid;//审批表状态ID
	private Integer atid;//审批类型ID
	private Integer pid;//权限ID
	private Integer flag;//软删除
	private String asname;//审批状态表的,审批状态属性
	private String uname;//员工姓名
	private User user;//用户对象
	private ApprovalStatus approvalstatus;//审批状态对象
	private String edescribe;//审批描述
	public Expense() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Expense(Integer exid, String exname, String unit, Double exmoney, Integer uid, Integer asid, Integer atid,
			Integer pid, Integer flag, String asname, String uname, User user, ApprovalStatus approvalstatus,
			String edescribe) {
		super();
		this.exid = exid;
		this.exname = exname;
		this.unit = unit;
		this.exmoney = exmoney;
		this.uid = uid;
		this.asid = asid;
		this.atid = atid;
		this.pid = pid;
		this.flag = flag;
		this.asname = asname;
		this.uname = uname;
		this.user = user;
		this.approvalstatus = approvalstatus;
		this.edescribe = edescribe;
	}
	public Integer getExid() {
		return exid;
	}
	public void setExid(Integer exid) {
		this.exid = exid;
	}
	public String getExname() {
		return exname;
	}
	public void setExname(String exname) {
		this.exname = exname;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public Double getExmoney() {
		return exmoney;
	}
	public void setExmoney(Double exmoney) {
		this.exmoney = exmoney;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public Integer getAsid() {
		return asid;
	}
	public void setAsid(Integer asid) {
		this.asid = asid;
	}
	public Integer getAtid() {
		return atid;
	}
	public void setAtid(Integer atid) {
		this.atid = atid;
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
	public String getAsname() {
		return asname;
	}
	public void setAsname(String asname) {
		this.asname = asname;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public ApprovalStatus getApprovalstatus() {
		return approvalstatus;
	}
	public void setApprovalstatus(ApprovalStatus approvalstatus) {
		this.approvalstatus = approvalstatus;
	}
	public String getEdescribe() {
		return edescribe;
	}
	public void setEdescribe(String edescribe) {
		this.edescribe = edescribe;
	}
	@Override
	public String toString() {
		return "Expense [exid=" + exid + ", exname=" + exname + ", unit=" + unit + ", exmoney=" + exmoney + ", uid="
				+ uid + ", asid=" + asid + ", atid=" + atid + ", pid=" + pid + ", flag=" + flag + ", asname=" + asname
				+ ", uname=" + uname + ", user=" + user + ", approvalstatus=" + approvalstatus + ", edescribe="
				+ edescribe + "]";
	}
}
