package com.woniuxy.oa.entity;

/**
 * 角色表
 * rid：编号
 * rname：角色名称
 * 
 * @author Administrator
 *
 */
public class Role {
	private int rid;
	private String rname;
	
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public String getRname() {
		return rname;
	}
	public void setRname(String rname) {
		this.rname = rname;
	}
	
	public Role(int rid, String rname) {
		super();
		this.rid = rid;
		this.rname = rname;
		
	}
	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Role [rid=" + rid + ", rname=" + rname + "]";
	}
	
	

}
