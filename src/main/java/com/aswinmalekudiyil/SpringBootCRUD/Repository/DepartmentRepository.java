package com.aswinmalekudiyil.SpringBootCRUD.Repository;

import com.aswinmalekudiyil.SpringBootCRUD.Entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {
    Department findBydepartmentName(String departmentName);
}
