package com.sma.demo.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sma.demo.entity.Department;
import com.sma.demo.repository.DepartmentRepository;

@Component
public class DepartmentServiceImpl implements DepartmentService {
	
	@Autowired
	private DepartmentRepository departmentRepository; 
	
	
	public Department saveDepartment(Department department) {
		return departmentRepository.save(department);
	}


	@Override
	public List<Department> fetchDepartmentList() {
		
		return departmentRepository.findAll();
	}


	@Override
	public Optional<Department> fetchDepartmentById(Long id) {
		
		return departmentRepository.findById(id);
	}


	@Override
	public void deleteDepartmentById(Long departmentId) {
		
		departmentRepository.deleteById(departmentId);
		
	}


	@Override
	public Department updateDepartment(Long id, Department dep) {
		
		Department depDB = departmentRepository.findById(id).get();
		
		if(Objects.nonNull(dep.getDepartmentName())
				&& !"".equals(dep.getDepartmentName()) ){
			depDB.setDepartmentName(dep.getDepartmentName());
		}
		
		if(Objects.nonNull(dep.getDepartmentCode())
				&& !"".equals(dep.getDepartmentCode()) ){
			depDB.setDepartmentCode(dep.getDepartmentCode());
		}
		if(Objects.nonNull(dep.getDepartmentAddress())
				&& !"".equals(dep.getDepartmentAddress()) ){
			depDB.setDepartmentAddress(dep.getDepartmentAddress());
		}
		
		return departmentRepository.save(depDB);
	}


	@Override
	public Department fetchDepartmentByName(String name) {
		return departmentRepository.findByDepartmentNameIgnoreCase(name);
		
	}
}
