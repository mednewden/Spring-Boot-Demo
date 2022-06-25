package com.sma.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.sma.demo.entity.Department;
import com.sma.demo.repository.DepartmentRepository;


@SpringBootTest
class DepartmentServiceTest {

	@Autowired
	private DepartmentService departmentService;
	
	@MockBean
	private DepartmentRepository departmentRepository;
	
	@BeforeEach
	void setUpBeforeClass() throws Exception {
		Department department = Department.builder()
				.departmentName("RH")
				.departmentAddress("CASA")
				.departmentCode("IM01")
				.departmentId(1L)
				.build();
		Mockito.when(departmentRepository.findByDepartmentNameIgnoreCase("RH")).thenReturn(department);
	}

	@Test
	@DisplayName("Get Data Based on valid department Name")
	void whenValidDepartmentName_thenDepartmentShouldFound() {
		String departmentName="RH";
		
		Department found= departmentService.fetchDepartmentByName(departmentName);
		
		assertEquals(departmentName, found.getDepartmentName());
		
		//fail("Not yet implemented");
	}

	
}
