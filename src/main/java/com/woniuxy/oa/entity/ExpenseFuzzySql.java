package com.woniuxy.oa.entity;

import java.io.Serializable;

/**
 * ExpenseFuzzySql类(报销管理表多表查询)
 * @author 张峻溢
 *
 */
public class ExpenseFuzzySql implements Serializable{
	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 1L;
	private Integer exid;//报销ID
	private String uname;//姓名
	private String exname;//报销项目名称
	private String unit;//计价单位
	private Double exmoney;//报销项目单价
	private String asname;//审批状态
	public ExpenseFuzzySql() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ExpenseFuzzySql(Integer exid, String uname, String exname, String unit, Double exmoney, String asname) {
		super();
		this.exid = exid;
		this.uname = uname;
		this.exname = exname;
		this.unit = unit;
		this.exmoney = exmoney;
		this.asname = asname;
	}
	public Integer getExid() {
		return exid;
	}
	public void setExid(Integer exid) {
		this.exid = exid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
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
	public String getAsname() {
		return asname;
	}
	public void setAsname(String asname) {
		this.asname = asname;
	}
	@Override
	public String toString() {
		return "ExpenseFuzzySql [exid=" + exid + ", uname=" + uname + ", exname=" + exname + ", unit=" + unit
				+ ", exmoney=" + exmoney + ", asname=" + asname + "]";
	}
	
	
}
