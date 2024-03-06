package com.tyss.repositiory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tyss.entity.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

}
