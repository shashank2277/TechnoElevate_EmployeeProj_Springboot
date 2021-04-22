package com.te.springboot.service;

import java.util.List;

import com.te.springboot.Beans.EmployeeBean;

public interface EmployeeService {
	public EmployeeBean getEmployee(int id);

	public boolean isdelete(int id);

	public List<EmployeeBean> getAllData();

	public boolean addEmployee(EmployeeBean bean);

	public boolean updateEmployee(EmployeeBean bean);

}
