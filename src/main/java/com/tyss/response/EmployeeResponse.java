package com.tyss.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class EmployeeResponse {
	
	private Long id;

	private String name;

	private String emailAddress;

	private String mobileNumber;

}
