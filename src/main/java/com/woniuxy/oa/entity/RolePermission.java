package com.woniuxy.oa.entity;

/**
 * 角色权限表
 * rpid：编号
 * rid：角色id
 * pid：权限id
 * @author Administrator
 *
 */
public class RolePermission {
	private int rpid;
	private int rid;
	private int pid;
	public int getRpid() {
		return rpid;
	}
	public void setRpid(int rpid) {
		this.rpid = rpid;
	}
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public RolePermission(int rpid, int rid, int pid) {
		super();
		this.rpid = rpid;
		this.rid = rid;
		this.pid = pid;
	}
	public RolePermission() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "RolePermission [rpid=" + rpid + ", rid=" + rid + ", pid=" + pid + "]";
	}
	

}
