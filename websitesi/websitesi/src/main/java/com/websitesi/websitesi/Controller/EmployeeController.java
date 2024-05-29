package com.websitesi.websitesi.Controller;

import com.websitesi.websitesi.Dto.EmployeeDTO;
import com.websitesi.websitesi.Response.Response;
import com.websitesi.websitesi.Services.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class EmployeeController {
    @Autowired
    private IEmployeeService employeeService;

    @PostMapping("/saveEmployee")
    public ResponseEntity<?> saveEmployee(@RequestBody EmployeeDTO employeeDTO) {
        Response registerResponse = employeeService.addEmployee(employeeDTO);
        return ResponseEntity.ok(registerResponse);
    }

    @DeleteMapping("/deleteEmployee/{employeeId}")
    public ResponseEntity<?> deleteEmployee(@PathVariable Long employeeId) {
        Response response = employeeService.deleteEmployee(employeeId);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/allEmployees")
    public ResponseEntity<?> getAllEmployees() {
        Response response = employeeService.getAllEmployee();
        return ResponseEntity.ok(response);
    }

    @PutMapping("/updateEmployee")
    public ResponseEntity<?> updateEmployee(@RequestBody EmployeeDTO employeeDTO) {
        Response updatedEmployeeResponse = employeeService.updateEmployee(employeeDTO);
        return ResponseEntity.ok(updatedEmployeeResponse); // Güncellenen aracı geri dön
    }
}
