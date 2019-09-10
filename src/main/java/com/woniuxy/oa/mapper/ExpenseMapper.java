package com.woniuxy.oa.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.woniuxy.oa.entity.Expense;
import com.woniuxy.oa.entity.ExpenseFuzzySql;
import com.woniuxy.oa.entity.User;

/**
 * Expense数据操作(报销管理)
 * @author 张峻溢
 *
 */
public interface ExpenseMapper {
	/**
	 * 查询所有报销条目(经理权限)
	 * @return List<Expense>
	 */
	List<Expense> selectAllExpense();
	
	/**
	 * 通过姓名模糊查询:查询所有报销条目(经理权限)
	 * @param uname
	 * @return List<Expense>
	 */
	List<User> selectAllExpenseByUname(@Param("user") User user);
	
	/**
	 * <多表>通过姓名模糊查询:查询所有报销条目(经理权限)
	 * @param user
	 * @return
	 */
	List<ExpenseFuzzySql> selectAllExpenseFuzzySqlByUname(
			@Param("user") User user,
			@Param("pageIndex")int pageIndex,
			@Param("pageSize")int pageSize);
	/**
	 * <多表>通过姓名模糊查询:查询总条数(经理权限)
	 * @param user
	 * @return
	 */
	int selectTotal(
			@Param("user") User user);
	/**
	 * 删除报销条目(经理权限)
	 * @param exid
	 */
	void deleteExpense(int exid);
	/**
	 * 查询所有姓名(添加信息需要用)
	 * @return
	 */
	List<User> selectUname();
	/**
	 * 根据姓名找uid
	 * @param uname
	 * @return
	 */
	int selectUidByUname(String uname);
	
	/**
	 *新增报销条目的方法 
	 */
	void addExpense(Expense expense);
	/**
	 * 修改报销条目的方法
	 * @param expense
	 */
	void updateExpense(Expense expense);
}
