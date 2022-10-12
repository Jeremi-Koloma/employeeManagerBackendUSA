package tech.getarrays.employeemanager.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tech.getarrays.employeemanager.Repository.EmployeeRepo;
import tech.getarrays.employeemanager.exception.UserNotFoundException;
import tech.getarrays.employeemanager.model.Employee;

import java.util.List;
import java.util.UUID;

@Service // Identifier cette classe comme service;
@AllArgsConstructor // Un constructer avec tous les arguments pour l'injection de notre EmployeeRepository;
public class EmployeeService {
    // Injection de Repository;
    private final EmployeeRepo employeeRepo;

    // Add Employee
    public Employee addEmployee(Employee employee){
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepo.save(employee);
    }

    // All Employees
    public List<Employee> findAllEmployees(){
        return employeeRepo.findAll();
    }

    // Update Employee
    public Employee updateEmployee(Employee employee){
        return employeeRepo.save(employee);
    }

    // Find an Employee
    public Employee findEmployeeById(Long id){
        return employeeRepo.findEmployeeById(id)
                .orElseThrow(()-> new UserNotFoundException("User by id" + id + "was not Found"));
    }

    // Delete Employee
    public void deleEmployee(Long id){
        employeeRepo.deleteEmployeeById(id);
    }

}
