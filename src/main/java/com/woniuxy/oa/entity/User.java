package com.woniuxy.oa.entity;

import java.util.Date;
import java.util.List;

/**
 * uid:用户编号
 * username：账号
 * password：密码
 * salt：盐
 * flag：软删除
 * rid：角色id
 * uname：姓名
 * did：部门编号
 * pids :权限id集合
 * logintime:登录时间
 * atids:审批权限
 * rname:角色名字
 * @author yy
 *
 */
public class User {
	private int uid;
	private String username;
	private String password;
	private String salt;
	private int flag;
	private int rid;
	private String uname;
	private int did;
	private List<Integer> pids;
	private Date logintime;
	private List<Integer> atids;
	private String rname;
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public int getDid() {
		return did;
	}
	public void setDid(int did) {
		this.did = did;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public List<Integer> getPids() {
		return pids;
	}
	public void setPids(List<Integer> pids) {
		this.pids = pids;
	}
	public Date getLogintime() {
		return logintime;
	}
	public void setLogintime(Date logintime) {
		this.logintime = logintime;
	}
	public List<Integer> getAtids() {
		return atids;
	}
	public void setAtids(List<Integer> atids) {
		this.atids = atids;
	}
	public String getRname() {
		return rname;
	}
	public void setRname(String rname) {
		this.rname = rname;
	}
	@Override
	public String toString() {
		return "User [uid=" + uid + ", username=" + username + ", password=" + password + ", salt=" + salt + ", flag="
				+ flag + ", rid=" + rid + ", uname=" + uname + ", did=" + did + ", pids=" + pids + ", logintime="
				+ logintime + ", atids=" + atids + ", rname=" + rname + "]";
	}
	public User(int uid, String username, String password, String salt, int flag, int rid, String uname, int did,
			List<Integer> pids, Date logintime, List<Integer> atids, String rname) {
		super();
		this.uid = uid;
		this.username = username;
		this.password = password;
		this.salt = salt;
		this.flag = flag;
		this.rid = rid;
		this.uname = uname;
		this.did = did;
		this.pids = pids;
		this.logintime = logintime;
		this.atids = atids;
		this.rname = rname;
	}
	
	

	
}
