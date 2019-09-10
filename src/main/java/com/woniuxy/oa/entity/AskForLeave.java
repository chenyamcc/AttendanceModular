package com.woniuxy.oa.entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;


/**
 *   请假模板
 * @author gao
 * alid：请假编号
 * datebegin:请假开始时间
 * dateend:请假结束时间
 * reason:请假时间
 * atid:审批类型
 * asid:审批状态
 * flag:软删除
 * user：用户
 */
public class AskForLeave implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int alid;
	private String leavetype;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date datebegin;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateend;
	private String reason;
	private int atid;
	private int asid;
	private int flag;
	private int uid;
	private String uname;
	private String asname;
	private String edescribe;
	public AskForLeave() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public AskForLeave(int alid, String leavetype, Date datebegin, Date dateend, String reason, int atid, int asid,
			int flag, int uid, String uname, String asname, String edescribe) {
		super();
		this.alid = alid;
		this.leavetype = leavetype;
		this.datebegin = datebegin;
		this.dateend = dateend;
		this.reason = reason;
		this.atid = atid;
		this.asid = asid;
		this.flag = flag;
		this.uid = uid;
		this.uname = uname;
		this.asname = asname;
		this.edescribe = edescribe;
	}

	public int getAlid() {
		return alid;
	}
	public void setAlid(int alid) {
		this.alid = alid;
	}
	public String getLeavetype() {
		return leavetype;
	}
	public void setLeavetype(String leavetype) {
		this.leavetype = leavetype;
	}
	public Date getDatebegin() {
		return datebegin;
	}
	public void setDatebegin(Date datebegin) {
		this.datebegin = datebegin;
	}
	public Date getDateend() {
		return dateend;
	}
	public void setDateend(Date dateend) {
		this.dateend = dateend;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public int getAtid() {
		return atid;
	}
	public void setAtid(int atid) {
		this.atid = atid;
	}
	public int getAsid() {
		return asid;
	}
	public void setAsid(int asid) {
		this.asid = asid;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getAsname() {
		return asname;
	}
	public void setAsname(String asname) {
		this.asname = asname;
	}
	
	
	public String getEdescribe() {
		return edescribe;
	}
	public void setEdescribe(String edescribe) {
		this.edescribe = edescribe;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "AskForLeave [alid=" + alid + ", leavetype=" + leavetype + ", datebegin=" + datebegin + ", dateend="
				+ dateend + ", reason=" + reason + ", atid=" + atid + ", asid=" + asid + ", flag=" + flag + ", uid="
				+ uid + ", uname=" + uname + ", asname=" + asname + ", edescribe=" + edescribe + "]";
	}

	
	
	
	
}
