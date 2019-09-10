package com.woniuxy.oa.entity;

import java.io.Serializable;

public class ApprovalStatus implements Serializable{
	
	private int asid;
	private String asname;
	public ApprovalStatus() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ApprovalStatus(int asid, String asname) {
		super();
		this.asid = asid;
		this.asname = asname;
	}
	public int getAsid() {
		return asid;
	}
	public void setAsid(int asid) {
		this.asid = asid;
	}
	public String getAsname() {
		return asname;
	}
	public void setAsname(String asname) {
		this.asname = asname;
	}
	@Override
	public String toString() {
		return "ApprovalStatus [asid=" + asid + ", asname=" + asname + "]";
	}
	
	
}
