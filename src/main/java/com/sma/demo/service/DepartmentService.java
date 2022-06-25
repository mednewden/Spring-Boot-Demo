package com.sma.demo.service;

import java.util.List;
import java.util.Optional;

import com.sma.demo.entity.Department;

public interface DepartmentService {

	Department saveDepartment(Department department);

	 List<Department> fetchDepartmentList();

	Optional<Department> fetchDepartmentById(Long departmentId);

	void deleteDepartmentById(Long departmentId);

	Department updateDepartment(Long id, Department department);

	Department fetchDepartmentByName(String name);

	

}
