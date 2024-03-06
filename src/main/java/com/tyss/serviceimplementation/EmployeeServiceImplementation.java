package com.tyss.serviceimplementation;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tyss.entity.Employee;
import com.tyss.exception.UserNotFoundException;
import com.tyss.repositiory.EmployeeRepository;
import com.tyss.request.EmployeeRequest;
import com.tyss.response.EmployeeResponse;
import com.tyss.service.EmployeeService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class EmployeeServiceImplementation implements EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public EmployeeResponse addEmployee(EmployeeRequest employeeRequest) {

		Employee employee = Employee.builder().build();
		BeanUtils.copyProperties(employeeRequest, employee);
		Employee savedEmployee = employeeRepository.save(employee);
		EmployeeResponse employeeResponse = EmployeeResponse.builder().build();
		BeanUtils.copyProperties(savedEmployee, employeeResponse);
		return employeeResponse;

	}

	public EmployeeResponse searchEmployee(long id) {
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new UserNotFoundException("Employee data is incorrect"));
		EmployeeResponse employeeResponse = EmployeeResponse.builder().build();
		BeanUtils.copyProperties(employee, employeeResponse);
		return employeeResponse;

	}

	public EmployeeResponse update(EmployeeRequest employeeRequest, long id) {
		Employee employee = (employeeRepository.findById(id)).orElse(null);
		employee = Employee.builder().id(employee.getId()).name(employeeRequest.getName())
				.emailAddress(employeeRequest.getEmailAddress()).mobileNumber(employeeRequest.getMobileNumber())
				.build();
		employeeRepository.save(employee);
		EmployeeResponse employeeResponse = EmployeeResponse.builder().build();
		BeanUtils.copyProperties(employee, employeeResponse);
		return employeeResponse;

	}

	public EmployeeResponse removeEmployee(Long eId) {
		Employee employee = employeeRepository.findById(eId).orElse(null);
		EmployeeResponse emplyeeResponse = EmployeeResponse.builder().build();
		BeanUtils.copyProperties(employee, emplyeeResponse);
		employeeRepository.delete(employee);
		return emplyeeResponse;

	}

	public List<EmployeeResponse> display() {
		List<EmployeeResponse> employeeRespose = employeeRepository.findAll().stream()
				.map(employee -> mapToGetStudentResponse(employee)).collect(Collectors.toList());
		return employeeRespose;
	}

	private EmployeeResponse mapToGetStudentResponse(Employee employee) {
		EmployeeResponse employeeResponse = EmployeeResponse.builder().build();
		BeanUtils.copyProperties(employee, employeeResponse);
		return employeeResponse;
	}

}
