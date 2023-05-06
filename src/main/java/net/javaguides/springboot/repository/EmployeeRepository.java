package net.javaguides.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.javaguides.springboot.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	List<Employee> findByFirstNameContainingIgnoreCase(String keyword);
	List<Employee> findByFirstNameContaining(String keyword);

	
	
}
//EmployeeRepository extends the JpaRepository interface, 
//which provides several methods for working with the Employee entity, 
//such as findAll(), findById(), save(), deleteById(), etc.