package com.dailyCodeBuffer.Spriing_boot_tutorial_yt.controller;

import com.dailyCodeBuffer.Spriing_boot_tutorial_yt.entity.Department;
import com.dailyCodeBuffer.Spriing_boot_tutorial_yt.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {

    //Here we use reference of our service using autowired i.e. wire the service instance to
    // the reference that we created. more 2 types there, constructor based,setter based
    @Autowired
    private DepartmentService departmentService;

    //Here @RequestBody is used to convert the requestBody into Department entity type
    @PostMapping("/departments")
    public Department saveDepartment(@RequestBody Department department){
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/departments/getAllDepartments")
    public List<Department> fetchDepartmentList(){
        return departmentService.fetchDepartmentList();
    }

    @GetMapping("/departments/getDepartmentById/{departmentId}")
    public Department fetchDepartmentById(@PathVariable Long departmentId){
        return departmentService.fetchDepartmentById(departmentId);
    }

    @DeleteMapping("/departments/deleteById/{departmentId}")
    public String deleteDepartmentById(@PathVariable Long departmentId){
        return departmentService.deleteDepartmentById(departmentId);
    }

    @PutMapping("/departments/updateById/{departmentId}")
    public Department updateDepartment(@PathVariable Long departmentId,
                                       @RequestBody Department department){
        return departmentService.updateDepartment(departmentId,department);
    }

    //This func is to be created in DepartmentRepository
    @GetMapping("/departments/getDepartmentByName/{departmentName}")
    public Department getDepartmentByName(@PathVariable String departmentName){
        return departmentService.getDepartmentByName(departmentName);
    }

}
