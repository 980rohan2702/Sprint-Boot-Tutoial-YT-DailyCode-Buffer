package com.dailyCodeBuffer.Spriing_boot_tutorial_yt.repository;

import com.dailyCodeBuffer.Spriing_boot_tutorial_yt.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {
    public Department findByDepartmentNameIgnoreCase(String departmentName);
}
