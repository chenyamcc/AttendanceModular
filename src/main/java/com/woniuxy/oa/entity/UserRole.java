package com.woniuxy.oa.entity;

public class UserRole {
	private int urid;
	private int rid;
	private int uid;
	public int getUrid() {
		return urid;
	}
	public void setUrid(int urid) {
		this.urid = urid;
	}
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public UserRole(int urid, int rid, int uid) {
		super();
		this.urid = urid;
		this.rid = rid;
		this.uid = uid;
	}
	public UserRole() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "UserRole [urid=" + urid + ", rid=" + rid + ", uid=" + uid + "]";
	}
	

}
