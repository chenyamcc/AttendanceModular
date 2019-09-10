package com.woniuxy.oa.entity;

/**
 * 权限菜单表
 * mid：菜单编号
 * mname：菜单名称
 * @author Administrator
 *
 */
public class Menu {
	private int mid;
	private String mname;
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public Menu(int mid, String mname) {
		super();
		this.mid = mid;
		this.mname = mname;
	}
	public Menu() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Menu [mid=" + mid + ", mname=" + mname + "]";
	}
	

}
