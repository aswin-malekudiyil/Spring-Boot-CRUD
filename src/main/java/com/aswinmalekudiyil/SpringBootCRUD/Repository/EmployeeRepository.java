package com.aswinmalekudiyil.SpringBootCRUD.Repository;

import com.aswinmalekudiyil.SpringBootCRUD.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    Employee findByemployeeName(String employeeName);
}
