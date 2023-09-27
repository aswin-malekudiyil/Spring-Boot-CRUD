package com.aswinmalekudiyil.SpringBootCRUD.Services;

import com.aswinmalekudiyil.SpringBootCRUD.DTO.EmployeeDTO;
import com.aswinmalekudiyil.SpringBootCRUD.Entity.Department;
import com.aswinmalekudiyil.SpringBootCRUD.Entity.Employee;
import com.aswinmalekudiyil.SpringBootCRUD.Repository.DepartmentRepository;
import com.aswinmalekudiyil.SpringBootCRUD.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;
    public List<Employee> getEmployees() {
        Sort sortById = Sort.by(Sort.Order.by("employeeId"));
        return employeeRepository.findAll(sortById);
    }

    public Employee addEmployee(Employee employee) {
        employeeRepository.save(employee);
        Employee emp = employeeRepository.findByemployeeName(employee.getEmployeeName());
        Employee empToSend = employeeRepository.findById(emp.getEmployeeId()).orElse(null);
        Department dep = departmentRepository.findById(employee.getDepartment().getDepartmentId()).orElse(null);
        empToSend.setDepartment(dep);
        return empToSend;
    }

    public String deleteEmployee(int id) {
        employeeRepository.deleteById(id);
        return "Deleted Employee";
    }

    public Employee updateEmployee(Employee employee) {
        Employee emp = employeeRepository.findById(employee.getEmployeeId()).orElse(null);
        if(Objects.nonNull(employee.getEmployeeName())&&!"".equalsIgnoreCase(employee.getEmployeeName())){
            emp.setEmployeeName(employee.getEmployeeName());
        }
        if(Objects.nonNull(employee.getEmail())&&!"".equalsIgnoreCase(employee.getEmail())){
            emp.setEmail(employee.getEmail());
        }
        if(Objects.nonNull(employee.getDepartment())){
            emp.setDepartment(employee.getDepartment());
        }
        return employeeRepository.save(emp);
    }

    public String deleteAllEmployees() {
        employeeRepository.deleteAll();
        return "Successfully Deleted All Employees";
    }

    public Employee getEmployeeByID(int id) {
       return employeeRepository.findById(id).orElse(null);
    }
}
