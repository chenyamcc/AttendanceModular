package com.woniuxy.oa.entity;

/**
 * 权限表
 * pid：编号
 * pname：权限名称
 * mid：菜单编号
 * purl：
 * percode：权限
 * @author Administrator
 *
 */
public class Permission {
	private int pid;
	private String pname;
	private int mid;
	private String purl;
	private String percode;
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public String getPurl() {
		return purl;
	}
	public void setPurl(String purl) {
		this.purl = purl;
	}
	public String getPercode() {
		return percode;
	}
	public void setPercode(String percode) {
		this.percode = percode;
	}
	public Permission(int pid, String pname, int mid, String purl, String percode) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.mid = mid;
		this.purl = purl;
		this.percode = percode;
	}
	public Permission() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Permission [pid=" + pid + ", pname=" + pname + ", mid=" + mid + ", purl=" + purl + ", percode="
				+ percode + "]";
	}
	
	

}
