package ma.dnaengineering.backend;

import ma.dnaengineering.backend.Repository.EmpRepo;
import ma.dnaengineering.backend.Services.EmpService;
import ma.dnaengineering.backend.model.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Collections;


@SpringBootTest
class BackendApplicationTests {
	@Mock
	private EmpRepo empRepo;

	@InjectMocks
	private EmpService empService;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}


	@Test
	void testProcessCSV() throws IOException {
		String csvContent = "id,employee_name,job_title,salary\n1,John,Developer,5000.0\n2,Jane,Manager,7000.0";
		BufferedReader bufferedReader = new BufferedReader(new StringReader(csvContent));


		when(empRepo.saveAll(Mockito.anyList())).thenAnswer(invocation -> invocation.getArgument(0));


		List<Employee> employees = empService.ProcessCSV();


		assertEquals(2, employees.size());
		assertEquals("John", employees.get(0).getEmployeeName());
		assertEquals("Manager", employees.get(1).getJobTitle());

		assertEquals(2, employees.size());
	}
	@Test
	void testGetAverageSalary() {

		when(empRepo.findAll()).thenReturn(Arrays.asList(
				new Employee("John", "Developer", 5000.0),
				new Employee("Jane", "Manager", 7000.0)
		));

		Map<String, Double> averageSalaries = empService.getAverageSalaryByJobTitle();

		assertEquals(2, averageSalaries.size());
		assertEquals(5000.0, averageSalaries.get("Developer"));
		assertEquals(7000.0, averageSalaries.get("Manager"));
	}
}





