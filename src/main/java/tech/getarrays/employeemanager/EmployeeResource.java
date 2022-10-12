package tech.getarrays.employeemanager;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.getarrays.employeemanager.Services.EmployeeService;
import tech.getarrays.employeemanager.model.Employee;

import java.util.List;

@RestController // Pour annoter la classe comme étant un controller;
@RequestMapping("/employee")
@AllArgsConstructor // Pour l'injection de notre EmployeeSerive
public class EmployeeResource {
    // Injectons le service
    private final EmployeeService employeeService;

    // List of Employee
    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmployees(){
        List<Employee> employees = employeeService.findAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    // Find an Employee
    @GetMapping("/find/{id}")
    public ResponseEntity<Employee> getEmployeeById (@PathVariable("id") Long id){
        Employee employee = employeeService.findEmployeeById(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    // Add Employee
    @PostMapping("/add")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
        Employee newEmployee = employeeService.addEmployee(employee);
        return new ResponseEntity<>(newEmployee, HttpStatus.CREATED );
    }

    // Update Employee
    @PutMapping("/update")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){
        Employee updateEmployee = employeeService.updateEmployee(employee);
        return new ResponseEntity<>(updateEmployee, HttpStatus.CREATED );
    }

    // Delete Employee
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id){
         employeeService.deleEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
