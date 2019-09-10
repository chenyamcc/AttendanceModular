package com.woniuxy.oa.service.impl;

import java.sql.SQLException;
import java.util.List;

import javax.crypto.interfaces.PBEKey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.ranges.RangeException;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniuxy.oa.entity.Expense;
import com.woniuxy.oa.entity.ExpenseFuzzySql;
import com.woniuxy.oa.entity.PageIngBean;
import com.woniuxy.oa.entity.User;
import com.woniuxy.oa.mapper.ExpenseMapper;

import com.woniuxy.oa.service.ExpenseService;

/**
 * Expense逻辑业务-实现类(报销管理)
 * @author 张峻溢
 *
 */
@Service("expenseService")
public class ExpenseServiceImp implements ExpenseService {
	//创建expenseMapper数据操作对象
	@Autowired
	ExpenseMapper expenseMapper;
	/**
	 *分页:查询所有报销PageBean(经理权限)
	 * @return PageBean<Expense>
	 */
	@Override
	public PageIngBean<Expense> expensePage(int pageIndex, int pageSize) {
		//创建PageHelper对象将当前页码和当前页显示的总条数传入其中
		PageHelper.startPage(pageIndex, pageSize);
		//取出查询的List对象
		List<Expense> expenses =  expenseMapper.selectAllExpense();
		//创建Pageinfo对象,再将查询的List数据放入PageInfo中
		PageInfo<Expense> pageinfo =new PageInfo<>(expenses);
		//获取总条数
		int toalRecpred = (int) pageinfo.getTotal();
		//创建PageBean对象(装配PageBen)
		PageIngBean pb = new PageIngBean();
		pb.setBeanList(expenses);
		pb.setPageIndex(pageIndex);
		pb.setPageSize(pageSize);
		pb.setToalRecpred(toalRecpred);
		pb.setpageBeginAndpageEnd();
		return pb;
	}
	/**
	 * 通过姓名模糊查询分页:查询所有报销条目(经理权限)
	 * @return PageBean<User>
	 */
	@Override
	public PageIngBean<User> expensePageByUname(int pageIndex, int pageSize, User user) {
		PageHelper.startPage(pageIndex, pageSize);
		List<User> users = expenseMapper.selectAllExpenseByUname(user);
		PageInfo<User> pageinfo = new PageInfo<>(users);
		int toalRecpred =(int) pageinfo.getTotal();
		//创建PageBen
		PageIngBean pb = new PageIngBean();
		pb.setBeanList(users);
		pb.setPageIndex(pageIndex);
		pb.setPageSize(pageSize);
		pb.setToalRecpred(toalRecpred);
		pb.setpageBeginAndpageEnd();
		return pb;
	}
	@Override
	public PageIngBean<ExpenseFuzzySql> expenseFuzzySqlPageByUname(int pageIndex, int pageSize, User user) {
		//页码显示规则
		int index = (pageIndex-1)*pageSize;
		int limit = pageSize;
		List<ExpenseFuzzySql> expenseFuzzySql=expenseMapper.selectAllExpenseFuzzySqlByUname(user, index, limit);
		int toalRecpred = expenseMapper.selectTotal(user);
		PageIngBean pb=new PageIngBean();
		pb.setBeanList(expenseFuzzySql);
		pb.setPageIndex(pageIndex);
		pb.setPageSize(pageSize);
		pb.setToalRecpred(toalRecpred);
		pb.setpageBeginAndpageEnd();
		return pb;
	}
	
	/**
	 * 删除报销条目(经理权限)
	 */
	@Override
	public void deleteExpenseByexid(int exid) {
	
			expenseMapper.deleteExpense(exid);
	
	}
	/**
	 * 查询所有姓名(添加信息需要用)
	 * @return
	 */
	@Override
	public List<User> selectUnameByAll() {
		List<User> users =expenseMapper.selectUname();
		return users;
	}
	/**
	 * 根据姓名找uid
	 */
	@Override
	public int selectUidbyUname(String uname) {
		int uid = expenseMapper.selectUidByUname(uname);
		return uid;
	}
	
	/**
	 * 新增报销条目
	 */
	@Override
	public void insertExpense(Expense expense) {
		expenseMapper.addExpense(expense);
	}
	
	/**
	 * 更新报销数据
	 */
	@Override
	public void updateExpense(Expense expense) {
		expenseMapper.updateExpense(expense);
	}
	
	

	

}
