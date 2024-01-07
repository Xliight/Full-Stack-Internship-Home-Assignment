package ma.dnaengineering.backend.Controller;

import ma.dnaengineering.backend.Services.EmpService;
import ma.dnaengineering.backend.Services.FileService;
import ma.dnaengineering.backend.model.Employee;
import ma.dnaengineering.backend.model.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping()
public class EmpController {

    @Autowired
    private EmpService employeeService;

    @Autowired
    private FileService fileService;

    @PostMapping("/SaveEmployees")
    public ResponseEntity<String> processCSV() {
        try {
            if (employeeService.employeesAlreadySaved()) {
                return ResponseEntity.status(HttpStatus.OK).body("Employees already saved");
            } else {
                employeeService.ProcessCSV();
                return ResponseEntity.status(HttpStatus.OK).body("CSV processing successful");
            }
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error processing CSV: " + e.getMessage());
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

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            fileService.saveFile(file.getOriginalFilename(), file);
            return ResponseEntity.ok("File uploaded successfully!");
        } catch (IOException e) {
            return ResponseEntity.status(500).body("Error uploading file: " + e.getMessage());
        }
    }

}
