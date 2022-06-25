package com.sma.demo.contoller;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.sma.demo.entity.Department;
import com.sma.demo.service.DepartmentService;

@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private DepartmentService departmentService;
	
	private Department department;
	
	@BeforeEach
	void setUpBeforeClass() throws Exception {
		
		department = Department.builder()
				.departmentName("IT")
				.departmentAddress("CASA")
				.departmentCode("IM01")
				.departmentId(1L)
				.build();
	}

	@Test
	//@Disabled 
	void testSaveDepartment() throws Exception {
		
		Department inputDep = Department.builder()
				.departmentName("IT")
				.departmentAddress("CASA")
				.departmentCode("IM01")
				.build();
		
		Mockito.when(departmentService.saveDepartment(inputDep)).thenReturn(department);
		
		mockMvc.perform(MockMvcRequestBuilders.post("/departments")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{	\r\n"
						+ "	\"departmentName\":\"IT\",\r\n"
						+ "	\"departmentAddress\":\"CASA\",\r\n"
						+ "	\"departmentCode\":\"IM01\"\r\n"
						+ "}")	
				).andExpect(MockMvcResultMatchers.status().isOk());
		
		
	}

	@Test
	void testFetchDepartmentByIdLong() throws Exception {
		
		Mockito.when(departmentService.fetchDepartmentById(1L)).thenReturn(Optional.of(department));
		
		Optional<Department> dep = departmentService.fetchDepartmentById(1L);
		
		mockMvc.perform(MockMvcRequestBuilders.get("/departments/1")
				.contentType(MediaType.APPLICATION_JSON)
				).andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(
						MockMvcResultMatchers.jsonPath("$.departmentName").value(department.getDepartmentName()));
	}

}
