package com.woniuxy.oa.entity;

import java.util.Arrays;
import java.util.Date;

/**
 * 通知公告表PO
 * 
 * id：主键列
 * ntitle：标题
 * ncontent：内容
 * nfilepath:文件上传路径
 * nfilename：上传文件名
 * atid：审批类型：            1-加班管理            2-请假管理            3-报销管理            4-申领管理            5-申购管理            6-公告审批（默认）
 * asid：审批状态：            1：未审批（默认）            2：审批中            3：已审批            4：未通过
 * ncreatetime：通知创建时间
 * nmodifytime：通知修改时间
 * receiverid：接收人id
 * senderid：发送人id
 * 
 * @author ChaoX
 *
 */

public class Notify {
	private int id;
	private String ntitle;
	private String ncontent;
	private String edescribe;
	private String nfilepath;
	private String nfilename;
	private int atid;
	private int asid;
	private Date ncreatetime;
	private Date nmodifytime;
	private int receiverid;
	private int senderid;

	public Notify() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Notify(int id, String ntitle, String ncontent, String edescribe, String nfilepath, String nfilename,
			int atid, int asid, Date ncreatetime, Date nmodifytime, int receiverid, int senderid) {
		super();
		this.id = id;
		this.ntitle = ntitle;
		this.ncontent = ncontent;
		this.edescribe = edescribe;
		this.nfilepath = nfilepath;
		this.nfilename = nfilename;
		this.atid = atid;
		this.asid = asid;
		this.ncreatetime = ncreatetime;
		this.nmodifytime = nmodifytime;
		this.receiverid = receiverid;
		this.senderid = senderid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNtitle() {
		return ntitle;
	}

	public void setNtitle(String ntitle) {
		this.ntitle = ntitle;
	}

	public String getNcontent() {
		return ncontent;
	}

	public void setNcontent(String ncontent) {
		this.ncontent = ncontent;
	}

	public String getEdescribe() {
		return edescribe;
	}

	public void setEdescribe(String edescribe) {
		this.edescribe = edescribe;
	}

	public String getNfilepath() {
		return nfilepath;
	}

	public void setNfilepath(String nfilepath) {
		this.nfilepath = nfilepath;
	}

	public String getNfilename() {
		return nfilename;
	}

	public void setNfilename(String nfilename) {
		this.nfilename = nfilename;
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

	public Date getNcreatetime() {
		return ncreatetime;
	}

	public void setNcreatetime(Date ncreatetime) {
		this.ncreatetime = ncreatetime;
	}

	public Date getNmodifytime() {
		return nmodifytime;
	}

	public void setNmodifytime(Date nmodifytime) {
		this.nmodifytime = nmodifytime;
	}

	public int getReceiverid() {
		return receiverid;
	}

	public void setReceiverid(int receiverid) {
		this.receiverid = receiverid;
	}

	public int getSenderid() {
		return senderid;
	}

	public void setSenderid(int senderid) {
		this.senderid = senderid;
	}

	@Override
	public String toString() {
		return "Notify [id=" + id + ", ntitle=" + ntitle + ", ncontent=" + ncontent + ", edescribe=" + edescribe
				+ ", nfilepath=" + nfilepath + ", nfilename=" + nfilename + ", atid=" + atid + ", asid=" + asid
				+ ", ncreatetime=" + ncreatetime + ", nmodifytime=" + nmodifytime + ", receiverid=" + receiverid
				+ ", senderid=" + senderid + "]";
	}

}
