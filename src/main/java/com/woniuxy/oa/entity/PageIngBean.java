package com.woniuxy.oa.entity;

import java.util.List;

/**
 * PageBean分页对象
 * @author Administrator
 *
 */
public class PageIngBean <T>{
	private List<T> beanList;//所有商品集合
	private int pageIndex;//当前页
	private int pageSize;//页码大小,一页显示多少条数据
	private int toalRecpred;//总商品条数
	private int totalPage;//总共的页
	private int pageBegin;//开始页
	private int pageEnd;//结束页
	private String url;//url
	/**
	 * 页码显示规则
	 */
	public void setpageBeginAndpageEnd() {
		//不够10页有多少显示多少
		if(getTotalPage()<10) {
			pageBegin=1;
			pageEnd=getTotalPage();
		}else {
			pageBegin=pageIndex-5;
			pageEnd=pageIndex+4;
			//上标越界
			if(pageIndex-5<1) {
				pageBegin=1;
				pageEnd=10;
			}
			//下标越界
			if(pageIndex+4>getTotalPage()) {
				pageBegin=getTotalPage()-9;
				pageEnd=getTotalPage();
			}
		}
	}
	
	public PageIngBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PageIngBean(List<T> beanList, int pageIndex, int pageSize, int toalRecpred, int totalPage, int pageBegin,
			int pageEnd, String url) {
		super();
		this.beanList = beanList;
		this.pageIndex = pageIndex;
		this.pageSize = pageSize;
		this.toalRecpred = toalRecpred;
		this.totalPage = totalPage;
		this.pageBegin = pageBegin;
		this.pageEnd = pageEnd;
		this.url = url;
	}
	public List<T> getBeanList() {
		return beanList;
	}
	public void setBeanList(List<T> beanList) {
		this.beanList = beanList;
	}
	public int getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getToalRecpred() {
		return toalRecpred;
	}
	public void setToalRecpred(int toalRecpred) {
		this.toalRecpred = toalRecpred;
	}
	public int getTotalPage() {
		return toalRecpred%pageSize==0?toalRecpred/pageSize:toalRecpred/pageSize+1;
	}
	
	public int getPageBegin() {
		return pageBegin;
	}
	public void setPageBegin(int pageBegin) {
		this.pageBegin = pageBegin;
	}
	public int getPageEnd() {
		return pageEnd;
	}
	public void setPageEnd(int pageEnd) {
		this.pageEnd = pageEnd;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	@Override
	public String toString() {
		return "PageBean [beanList=" + beanList + ", pageIndex=" + pageIndex + ", pageSize=" + pageSize
				+ ", toalRecpred=" + toalRecpred + ", totalPage=" + totalPage + ", pageBegin=" + pageBegin
				+ ", pageEnd=" + pageEnd + ", url=" + url + "]";
	}
	
}
