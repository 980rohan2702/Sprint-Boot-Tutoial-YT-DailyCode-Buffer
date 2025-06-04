package com.dailyCodeBuffer.Spriing_boot_tutorial_yt.service;

import com.dailyCodeBuffer.Spriing_boot_tutorial_yt.entity.Department;
import com.dailyCodeBuffer.Spriing_boot_tutorial_yt.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService{
    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department){
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> fetchDepartmentList(){
        return departmentRepository.findAll();
    }

    @Override
    public Department fetchDepartmentById(Long departmentId){
        return departmentRepository.findById(departmentId).get();
    }

    @Override
    public String deleteDepartmentById(Long departmentId){
        departmentRepository.deleteById(departmentId);
        return "Department " +departmentId+" deleted successfully";
    }

    @Override
    public Department updateDepartment(Long departmentId , Department department){
        Department debDB = departmentRepository.findById(departmentId).get();

        if(department.getDepartmentCode()!=null &&
                !(department.getDepartmentCode().equalsIgnoreCase(debDB.getDepartmentCode())) ){
            debDB.setDepartmentCode(department.getDepartmentCode());
        }
        if(department.getDepartmentAddress()!=null &&
                !(department.getDepartmentAddress().equalsIgnoreCase(debDB.getDepartmentAddress())) ){
            debDB.setDepartmentAddress(department.getDepartmentAddress());
        }
        if(department.getDepartmentName()!=null &&
                !(department.getDepartmentName().equalsIgnoreCase(debDB.getDepartmentName())) ){
            debDB.setDepartmentName(department.getDepartmentName());
        }

        return departmentRepository.save(debDB);
    }

    @Override
    public Department getDepartmentByName(String departmentName){
        return departmentRepository.findByDepartmentNameIgnoreCase(departmentName);
    }
}
