package com.woniuxy.oa.entity;

import java.util.List;

public class PageBean<T> {
	private List<T> userNews;//用户信息
	private int totalPages;//总页数
	private int pageSizes;//页大小
	private int page;//当前页索引
	private int totalNews;//总记录条数
	private int pageBegin;//开始页
	private int pageEnd;//终止页
	private String url;//封装请求参数，在上一页和下一页时使用
	
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
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
	public void setpageBeginpageEnd(){
		if(getTotalPages()<10){
			pageBegin=1;
			pageEnd=getTotalPages();
		}else{
			pageBegin=page-5;
			pageEnd=page+4;
			//下限判断
			if(page-5<1){
				pageBegin=1;
				pageEnd=10;
			}
			//上限判断
			if(page+4>30){
				pageBegin=page-9;
				pageEnd=getTotalPages();
			}
			if(getTotalPages()-page<4){
				pageEnd=getTotalPages();
			}
		}
	}
	public List<T> getUserNews() {
		return userNews;
	}
	public void setUserNews(List<T> userNews) {
		this.userNews = userNews;
	}
	public int getTotalPages() {
		return totalNews%pageSizes==0?totalNews/pageSizes:totalNews/pageSizes+1;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	public int getPageSizes() {
		return pageSizes;
	}
	public void setPageSizes(int pageSizes) {
		this.pageSizes = pageSizes;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getTotalNews() {
		return totalNews;
	}
	public void setTotalNews(int totalNews) {
		this.totalNews = totalNews;
	}
	
	
	public PageBean(List<T> userNews, int totalPages, int pageSizes, int page, int totalNews, int pageBegin,
			int pageEnd, String url) {
		super();
		this.userNews = userNews;
		this.totalPages = totalPages;
		this.pageSizes = pageSizes;
		this.page = page;
		this.totalNews = totalNews;
		this.pageBegin = pageBegin;
		this.pageEnd = pageEnd;
		this.url = url;
	}
	public PageBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "PageBean [userNews=" + userNews + ", totalPages=" + totalPages + ", pageSizes=" + pageSizes + ", page="
				+ page + ", totalNews=" + totalNews + ", pageBegin=" + pageBegin + ", pageEnd=" + pageEnd + ", url="
				+ url + "]";
	}

	
}
