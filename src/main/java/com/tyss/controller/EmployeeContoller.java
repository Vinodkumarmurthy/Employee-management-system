package com.tyss.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tyss.request.EmployeeRequest;
import com.tyss.response.EmployeeResponse;
import com.tyss.response.SucessResponse;
import com.tyss.service.EmployeeService;

@RestController
@RequestMapping("/emp")
public class EmployeeContoller {
	@Autowired
	private EmployeeService employeeService;

	@PostMapping("/add")
	public ResponseEntity<SucessResponse> addEmp(@RequestBody EmployeeRequest employeeRequest) {

		
		return ResponseEntity.ok(SucessResponse.builder().error(Boolean.FALSE).
				message("Employee Added sucessfully").data(employeeService.addEmployee(employeeRequest)).build());

	}

	@GetMapping("/search/{sId}")
	public  ResponseEntity<SucessResponse> searchEmployee(@PathVariable long sId) {
		return ResponseEntity.ok(SucessResponse.builder().error(Boolean.FALSE).
				message("Sucessfully Got Employee Data").data(employeeService.searchEmployee(sId)).build());
	}

	@PutMapping("update/{sId}")
	public ResponseEntity<SucessResponse> updateEmployee(@RequestBody EmployeeRequest employeeRequest, @PathVariable long sId) {
		return ResponseEntity.ok(SucessResponse.builder().error(Boolean.FALSE).
				message("Succesfully Updated Employee").data(employeeService.update(employeeRequest, sId)).build());
		

	}

	@DeleteMapping("/remove/{sId}")
	public  ResponseEntity<SucessResponse> RemoveEmployee(@PathVariable Long sId) {
		return ResponseEntity.ok(SucessResponse.builder().error(Boolean.FALSE).
				message("Succesfully Removed Employee").data(employeeService.removeEmployee(sId)).build());
	}

	@GetMapping("/display")
	public  ResponseEntity<SucessResponse> display() {
		 return ResponseEntity.ok(SucessResponse.builder().error(Boolean.FALSE).
				message("Succesfully Fetched all Employee").data(employeeService.display()).build());
	}

}
