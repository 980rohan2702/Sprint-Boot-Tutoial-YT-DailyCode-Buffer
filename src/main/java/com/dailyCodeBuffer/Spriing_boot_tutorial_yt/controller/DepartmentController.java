package com.dailyCodeBuffer.Spriing_boot_tutorial_yt.controller;

import com.dailyCodeBuffer.Spriing_boot_tutorial_yt.advice.ApiResponse;
import com.dailyCodeBuffer.Spriing_boot_tutorial_yt.advice.ResourceNotFoundException;
import com.dailyCodeBuffer.Spriing_boot_tutorial_yt.advice.UnexpectedException;
import com.dailyCodeBuffer.Spriing_boot_tutorial_yt.entity.Department;
import com.dailyCodeBuffer.Spriing_boot_tutorial_yt.service.DepartmentService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController

public class DepartmentController {

    //Here we use reference of our service using autowired i.e. wire the service instance to
    // the reference that we created. more 2 types there, constructor based,setter based
    @Autowired
    private DepartmentService departmentService;

    private final Logger logger = LoggerFactory.getLogger(DepartmentController.class);

    //Here @RequestBody is used to convert the requestBody into Department entity type
    //Valid annotation used to trigger the validation applied in entity
    @PostMapping("/departments")
    public Department saveDepartment(@Valid @RequestBody Department department){
        logger.info("Inside save department API");
        return departmentService.saveDepartment(department);
    }

    //Changed for exception handling
    @GetMapping("/departments/getAllDepartments")
    public ResponseEntity<ApiResponse<List<Department>>> fetchDepartmentList(){
//        List<Department> departments = departmentService
//                .fetchDepartmentList()
//                .orElseThrow(()->new ResourceNotFoundException("No depts found"));

        List<Department> departments = departmentService
                .fetchDepartmentList()
                .orElseThrow(()->new UnexpectedException("No depts found"));
        return ResponseEntity.ok(ApiResponse.success(departments));
    }

    @GetMapping("/departments/getDepartmentById/{departmentId}")
    public ResponseEntity<ApiResponse<Department>> fetchDepartmentById(@PathVariable Long departmentId){
        Department department = departmentService
                .fetchDepartmentById(departmentId)
                .orElseThrow(()->new ResourceNotFoundException("No dept with id found"));
        return ResponseEntity.ok(ApiResponse.success(department));
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
