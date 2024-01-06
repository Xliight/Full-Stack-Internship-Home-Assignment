package ma.dnaengineering.backend.Controller;

import ma.dnaengineering.backend.Services.EmpService;
import ma.dnaengineering.backend.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping()
public class EmpController {

    @Autowired
    private EmpService employeeService;

    @GetMapping("/AllEmployees")
    public List<Employee> getAllEmployees() throws IOException {
        return employeeService.ProcessCSV();
    }

    @GetMapping("/AverageSalaryByJob")
    public Map<String, Double> getAverageSalaryByJobTitle() {
        return employeeService.getAverageSalaryByJobTitle();
    }

}