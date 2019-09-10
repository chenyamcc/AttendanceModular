package com.woniuxy.oa.entity;

import java.util.List;

public class PageBeaning<T> {
	
	//设置一个集合装总页码
	private List<T> beanList;//数据库查询
	private int pageIndex;//当前页及客户请求参数
	private int pageSize;//页大小,每页显示总条数
	private int totalRecored;//总记录条数
	private int totalPage;//总页数
	private int pageBegin;//起始页
	private int pageEnd;//结束页
	private String url;//封装请求路径参数
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setPageBeginAndPageEnd() {
		//不够10页
		if(getTotalPage()<10) {
			pageBegin=1;
			pageEnd=getTotalPage();
		}else {
			pageBegin=pageIndex-5;
			pageEnd=pageIndex+4;
			//上边界越界
			if(pageIndex-5<1) {
				pageBegin=1;
				pageEnd=10;
			}
			//下边界越界
			if(pageIndex+4>getTotalPage()) {
				pageBegin=getTotalPage()-9;
				pageEnd=getTotalPage();
			}
		}
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
	public int getTotalRecored() {
		return totalRecored;
	}
	public void setTotalRecored(int totalRecored) {
		this.totalRecored = totalRecored;
	}
	
	public int getTotalPage() {
		//总条数%页大小
		return totalRecored%pageSize==0?totalRecored/pageSize:totalRecored/pageSize+1;
	}
	
	
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
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
	public PageBeaning(List<T> beanList, int pageIndex, int pageSize, int totalRecored, int totalPage, int pageBegin,
			int pageEnd) {
		super();
		this.beanList = beanList;
		this.pageIndex = pageIndex;
		this.pageSize = pageSize;
		this.totalRecored = totalRecored;
		this.totalPage = totalPage;
		this.pageBegin = pageBegin;
		this.pageEnd = pageEnd;
	}
	public PageBeaning() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "PageBean [beanList=" + beanList + ", pageIndex=" + pageIndex + ", pageSize=" + pageSize
				+ ", totalRecored=" + totalRecored + ", totalPage=" + totalPage + ", pageBegin=" + pageBegin
				+ ", pageEnd=" + pageEnd + ", url=" + url + "]";
	}

	

	
}
