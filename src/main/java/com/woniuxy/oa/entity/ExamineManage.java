package com.woniuxy.oa.entity;

import java.util.List;

public class ExamineManage<T> {
	private List<T> examines;

	@Override
	public String toString() {
		return "ExamineManage [examines=" + examines + "]";
	}

	public ExamineManage() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ExamineManage(List<T> examines) {
		super();
		this.examines = examines;
	}

	public List<T> getExamines() {
		return examines;
	}

	public void setExamines(List<T> examines) {
		this.examines = examines;
	}
	
}
