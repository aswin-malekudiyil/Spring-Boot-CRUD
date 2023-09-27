package com.aswinmalekudiyil.SpringBootCRUD.Services;

import com.aswinmalekudiyil.SpringBootCRUD.Entity.Department;
import com.aswinmalekudiyil.SpringBootCRUD.Repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    public Department addDepartment(Department department) {
       return departmentRepository.save(department);
    }

    public Department getDepartmentById(int id) {
        return departmentRepository.findById(id).orElse(null);
    }

    public Department getDepartmentByName(String departmentName) {
       return departmentRepository.findBydepartmentName(departmentName);
    }

    public String deleteById(int id) {
        departmentRepository.deleteById(id);
        return "Deleted Successfully";
    }

    public Department updateDepartment(Department department) {
        Department dep = new Department();
        dep = departmentRepository.findById(department.getDepartmentId()).orElse(null);
        if (Objects.nonNull(department.getDepartmentName())&& !"".equalsIgnoreCase(department.getDepartmentName())){
            dep.setDepartmentName(department.getDepartmentName());
        }
        if (Objects.nonNull(department.getDepartmentCode())&& !"".equalsIgnoreCase(department.getDepartmentCode())){
            dep.setDepartmentCode(department.getDepartmentCode());
        }
        return departmentRepository.save(dep);
    }
}
