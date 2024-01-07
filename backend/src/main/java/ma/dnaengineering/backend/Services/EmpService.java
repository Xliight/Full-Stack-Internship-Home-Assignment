package ma.dnaengineering.backend.Services;

import lombok.Value;
import ma.dnaengineering.backend.Repository.EmpRepo;
import ma.dnaengineering.backend.model.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class EmpService {

    @Autowired
    private EmpRepo employeeRepository;
    private String csvFilePath="C:\\Users\\Xlight\\Desktop\\Full-Stack-Internship-Home-Assignment\\data\\employees.csv";

    private Employee mapToEmployee(String line) {
        String[] fields = line.split(",");
        String employeeName = fields[1];
        String jobTitle = fields[2];
        double salary = Double.parseDouble(fields[3].replace(",", ""));
        return new Employee(employeeName, jobTitle, salary);
    }
    public void ProcessCSV() throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
            br.lines()
                    .skip(1) // Skip header
                    .map(this::mapToEmployee)
                    .forEach(employeeRepository::save);
        }
    }
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Map<String, Double> getAverageSalaryByJobTitle() {
        return employeeRepository.findAll().stream()
                .collect(Collectors.groupingBy(Employee::getJobTitle,
                        Collectors.averagingDouble(Employee::getSalary)));
    }

    public boolean employeesAlreadySaved() {
        return employeeRepository.count() > 0;
    }


}
