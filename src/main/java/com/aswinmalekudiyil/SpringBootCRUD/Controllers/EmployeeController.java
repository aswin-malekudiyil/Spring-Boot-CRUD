package com.aswinmalekudiyil.SpringBootCRUD.Controllers;

import com.aswinmalekudiyil.SpringBootCRUD.DTO.EmployeeDTO;
import com.aswinmalekudiyil.SpringBootCRUD.Entity.Employee;
import com.aswinmalekudiyil.SpringBootCRUD.Services.EmployeeService;
import org.apache.tomcat.util.http.fileupload.util.LimitedInputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("employee")
@CrossOrigin(origins = "*")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/")
    public List<Employee> getEmployees(){
        return employeeService.getEmployees();
    }

    @GetMapping("/view/{id}")
    public Employee getEmployeeByID(@PathVariable("id") int id){
       return employeeService.getEmployeeByID(id);
    }

    @PostMapping("/")
    public Employee addEmployee(@RequestBody Employee employee){
        return employeeService.addEmployee(employee);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable("id") int id){
        return employeeService.deleteEmployee(id);
    }

    @PutMapping("/update")
    public Employee updateEmployee(@RequestBody Employee employee){
        return employeeService.updateEmployee(employee);
    }

    @DeleteMapping("/delete/deletAll")
    public String deleteAllEmployees(){
        return employeeService.deleteAllEmployees();
    }
}
