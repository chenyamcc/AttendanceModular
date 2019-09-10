package com.woniuxy.oa.utils;

import javax.servlet.http.HttpServletRequest;

public class PageUtils {
	
	/**
	 * 获取当前页面url
	 * @param request
	 * @return
	 */
	public static String getUrl(HttpServletRequest request) {
		String contextPath = request.getContextPath();//获取上下文路径(资源名)
		String servletPath = request.getServletPath();//获取servlet的地址
		String queryString = request.getQueryString();//获得整个请求参数，不带问号
		
		if(queryString!=null&&queryString.indexOf("&page=")!=-1){
		//请求的字符串最后一个是当前的页数，而这个页数是需要通过前端来获取的，他在整个请求字符串的最后一个&之后，所以把他拆除掉
		queryString=queryString.substring(0, queryString.lastIndexOf("&")); }
		 
		return contextPath+servletPath+"?"+queryString;
	}
	
	/**
	 * 获取当前页码
	 * @param request
	 * @return
	 */
	public static int getPageIndex(HttpServletRequest request) {
		String page=request.getParameter("page");
		if(page==null||page.equals("")){
			return 1;
		}
		return Integer.parseInt(page);
	}
}
