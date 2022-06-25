package com.sma.demo.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.sma.demo.entity.Department;


@DataJpaTest
class DepartmentRepositoryTest {
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Autowired
	private TestEntityManager entityManager;
	

	@BeforeEach
	void setUpBeforeClass() throws Exception {
		Department department = Department.builder()
				.departmentName("IT")
				.departmentAddress("CASA")
				.departmentCode("IM01")
				.build();
		entityManager.persist(department);
	}

	@Test
	void whenFindById_thenReturnDepartment() {
		Department department = departmentRepository.findById(1L).get();
		assertEquals("IT", department.getDepartmentName());
				
		//fail("Not yet implemented");
	}

}
