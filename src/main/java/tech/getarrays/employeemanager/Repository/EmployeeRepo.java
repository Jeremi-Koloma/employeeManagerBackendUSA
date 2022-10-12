package tech.getarrays.employeemanager.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.getarrays.employeemanager.model.Employee;

import java.util.Optional;

// Cette interface va étendre de l'interface JPA Repository avec l'entity et le type de son primary key
public interface EmployeeRepo extends JpaRepository<Employee, Long> {
    // Delete Employee
    void deleteEmployeeById(Long id);

    // Find an Employee
    Optional<Employee> findEmployeeById(Long id);
}
