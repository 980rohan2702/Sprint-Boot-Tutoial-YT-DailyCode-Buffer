package com.dailyCodeBuffer.Spriing_boot_tutorial_yt.service;

import com.dailyCodeBuffer.Spriing_boot_tutorial_yt.entity.Department;

import java.util.List;

public interface DepartmentService {
    public Department saveDepartment(Department department);
    public List<Department> fetchDepartmentList();
    public Department fetchDepartmentById(Long departmentId);
    public String deleteDepartmentById(Long departemntId);
    public Department updateDepartment(Long departmentId , Department department);
    public Department getDepartmentByName(String departmentName);
}
