package ma.dnaengineering.backend.Controller;

import ma.dnaengineering.backend.Services.EmpService;
import ma.dnaengineering.backend.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping()
public class EmpController {

    @Autowired
    private EmpService employeeService;

    @PostMapping("/SaveEmployees")
    public String processCSV() {
        try {
            employeeService.ProcessCSV();
            return "CSV processing successful";
        } catch (IOException e) {
            return "Error processing CSV: " + e.getMessage();
        }
    }

    @GetMapping("/AllEmployees")
    public List<Employee> getAllEmployees() throws IOException {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/AverageSalaryByJob")
    public Map<String, Double> getAverageSalaryByJobTitle() {
        return employeeService.getAverageSalaryByJobTitle();
    }

}