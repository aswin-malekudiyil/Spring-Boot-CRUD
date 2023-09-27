package com.aswinmalekudiyil.SpringBootCRUD.Controllers;

import com.aswinmalekudiyil.SpringBootCRUD.Entity.Department;
import com.aswinmalekudiyil.SpringBootCRUD.Services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("department")
@CrossOrigin(origins = "*")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/")
    public List<Department> getAllDepartments(){
        return departmentService.getAllDepartments();
    }

    @PostMapping("/")
    public Department addDepartment(@RequestBody Department department){
        return  departmentService.addDepartment(department);
    }

    @GetMapping("/find/{id}")
    public Department getDepartmentById(@PathVariable("id") int id){
        return departmentService.getDepartmentById(id);
    }

    @GetMapping("/view/{departmentName}")
    public Department getDepartmentByName(@PathVariable("departmentName") String departmentName){
        return departmentService.getDepartmentByName(departmentName);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteById(@PathVariable("id") int id){
        return departmentService.deleteById(id);
    }

    @PutMapping("/update")
    public Department updateDepartment(@RequestBody Department department){
        return departmentService.updateDepartment(department);
    }
}

