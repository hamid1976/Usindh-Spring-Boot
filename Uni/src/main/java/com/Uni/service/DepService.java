package com.Uni.service;

import com.Uni.model.Department;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DepService {

    //get All Department
    public List<Department> getAllDepartment();

    //get Department By dep id
    public Department getDepartmentById(int id);

    //add department
    public Department addDepartment(Department department);

    //update department
    public  void updateDepartment(Department department,int id);

    //delete department by id
    public void deleteDepartment(int id);

}
