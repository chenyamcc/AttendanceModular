package com.woniuxy.oa.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.woniuxy.oa.entity.Expense;
import com.woniuxy.oa.entity.ExpenseFuzzySql;
import com.woniuxy.oa.entity.PageIngBean;
import com.woniuxy.oa.entity.User;

/**
 * Expense逻辑业务(报销管理)
 * @author 张峻溢
 *
 */
public interface ExpenseService {
	/**
	 * 分页:查询所有报销条目(经理权限)
	 * @param pageIndex 当前页码
	 * @param pageSize	每页显示多少条数据
	 * @returnPageBean<Expense>
	 */
	PageIngBean<Expense> expensePage(int pageIndex,int pageSize);
	
	/**
	 * 通过姓名模糊查询分页:查询所有报销条目(经理权限)
	 * @param pageIndex 当前页码
	 * @param pageSize	每页显示的数据
	 * @param user	传来的Uuname
	 * @return PageBean<User>
	 */
	PageIngBean<User> expensePageByUname(int pageIndex,int pageSize,User user);
	
	/**
	 * 通过姓名模糊查询分页:查询所有报销条目(经理权限)
	 * @param pageIndex 当前页码
	 * @param pageSize	每页显示的数据
	 * @param user	传来的Uuname
	 * @return PageBean<ExpenseFuzzySql>
	 */
	PageIngBean<ExpenseFuzzySql> expenseFuzzySqlPageByUname(int pageIndex,int pageSize,User user);
	
	/**
	 * 删除报销条目(经理权限)
	 * @param exid
	 */
	void deleteExpenseByexid(int exid);
	
	/**
	 * 查询所有姓名(添加信息需要用)
	 * @return
	 */
	List<User> selectUnameByAll();
	/**
	 * 根据姓名找uid
	 * @param uname
	 * @return
	 */
	int selectUidbyUname(String uname);
	/**
	 * 新增报销条目
	 * @param expense
	 */
	void insertExpense(Expense expense);
	/**
	 * 更新报销条目
	 * @param expense
	 */
	void updateExpense(Expense expense);
}

