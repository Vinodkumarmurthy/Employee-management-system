package com.tyss.service;

import java.util.List;

import com.tyss.request.EmployeeRequest;
import com.tyss.response.EmployeeResponse;

public interface EmployeeService {
	
	public  EmployeeResponse addEmployee(EmployeeRequest employeeRequest);
	public EmployeeResponse searchEmployee(long id);
	public EmployeeResponse update(EmployeeRequest employeeRequest,long id);
	public EmployeeResponse removeEmployee(Long eId);
	public List<EmployeeResponse> display();

}
