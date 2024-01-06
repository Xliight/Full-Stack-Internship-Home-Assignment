package ma.dnaengineering.backend;

import ma.dnaengineering.backend.Repository.EmpRepo;
import ma.dnaengineering.backend.Repository.FileRepo;
import ma.dnaengineering.backend.Services.EmpService;
import ma.dnaengineering.backend.Services.FileService;
import ma.dnaengineering.backend.model.Employee;
import ma.dnaengineering.backend.model.File;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;
import static sun.java2d.cmm.ProfileDataVerifier.verify;

import java.util.List;


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


	@Mock
	private FileRepo fileRepository;

	@InjectMocks
	private FileService fileService;

	@Test
	public void testSaveFile() throws IOException {
		// Create a mock MultipartFile
		MockMultipartFile mockFile = new MockMultipartFile(
				"testFile", "test.txt", "text/plain", "Hello, World!".getBytes());

		// Create a mock File object that would be returned by the repository
		File mockSavedFile = new File();
		mockSavedFile.setId(1L);
		mockSavedFile.setName("test.txt");

		// Mock the behavior of the fileRepository.save method
		when(fileRepository.save(any(File.class))).thenReturn(mockSavedFile);

		// Call the saveFile method
		File savedFile = fileService.saveFile(mockFile);

		// Verify that the save method of fileRepository was called
		verify(fileRepository, times(1)).save(any(File.class));

		// Assert that the savedFile has the expected attributes
		assertEquals(1L, savedFile.getId());
		assertEquals("test.txt", savedFile.getName());
	}

	@Test
	public void testGetFileById() {
		// Create a mock File object that would be returned by the repository
		File mockFile = new File();
		mockFile.setId(1L);
		mockFile.setName("test.txt");

		// Mock the behavior of the fileRepository.findById method
		when(fileRepository.findById(1L)).thenReturn(Optional.of(mockFile));

		// Call the getFileById method
		File retrievedFile = fileService.getFile(1L);

		// Verify that the findById method of fileRepository was called
		verify(fileRepository, times(1)).findById(1L);

		// Assert that the retrievedFile has the expected attributes
		assertEquals(1L, retrievedFile.getId());
		assertEquals("test.txt", retrievedFile.getName());
	}
}
}





