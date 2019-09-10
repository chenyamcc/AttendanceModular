package com.woniuxy.oa.entity;

/**
 * 考勤设置表
 * asid：考勤设置的编号
 * begintime：上班时间
 * afternoonbegintime：午休开始时间
 * afternoonendtime：午休结束时间
 * resttime：下班时间
 * @author Administrator
 *
 */
public class AttendanceSetting {
	private int asid;
	private String begintime;
	private String afternoonbegintime;
	private String afternoonendtime;
	private String resttime;
	private String settime;
	private int flag;
	public int getAsid() {
		return asid;
	}
	public void setAsid(int asid) {
		this.asid = asid;
	}
	public String getBegintime() {
		return begintime;
	}
	public void setBegintime(String begintime) {
		this.begintime = begintime;
	}
	public String getAfternoonbegintime() {
		return afternoonbegintime;
	}
	public void setAfternoonbegintime(String afternoonbegintime) {
		this.afternoonbegintime = afternoonbegintime;
	}
	public String getAfternoonendtime() {
		return afternoonendtime;
	}
	public void setAfternoonendtime(String afternoonendtime) {
		this.afternoonendtime = afternoonendtime;
	}
	public String getResttime() {
		return resttime;
	}
	public void setResttime(String resttime) {
		this.resttime = resttime;
	}
	public String getSettime() {
		return settime;
	}
	public void setSettime(String settime) {
		this.settime = settime;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public AttendanceSetting(int asid, String begintime, String afternoonbegintime, String afternoonendtime, String resttime,
							 String settime, int flag) {
		super();
		this.asid = asid;
		this.begintime = begintime;
		this.afternoonbegintime = afternoonbegintime;
		this.afternoonendtime = afternoonendtime;
		this.resttime = resttime;
		this.settime = settime;
		this.flag = flag;
	}
	public AttendanceSetting() {

	}
	@Override
	public String toString() {
		return "AttendanceSetting [asid=" + asid + ", begintime=" + begintime + ", afternoonbegintime="
				+ afternoonbegintime + ", afternoonendtime=" + afternoonendtime + ", resttime=" + resttime
				+ ", settime=" + settime + ", flag=" + flag + "]";
	}



}
