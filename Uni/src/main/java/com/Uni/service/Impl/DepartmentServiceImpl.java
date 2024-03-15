package com.Uni.service.Impl;

import com.Uni.model.Department;
import com.Uni.model.Faculty;
import com.Uni.repo.DepRepository;
import com.Uni.repo.FacRepository;
import com.Uni.service.DepService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;


@Component
public class DepartmentServiceImpl implements DepService {

    @Autowired
    private DepRepository depRepository;

    @Autowired
    private FacRepository facRepository;


    //get All Department
    public List<Department> getAllDepartment(){
        List<Department> list=this.depRepository.findAll();
        return list;
    }

    //get Department By Id
    public Department getDepartmentById(int deptId){
        Department department=null;
        try{
            department= this.depRepository.findById(deptId);
        }catch(Exception e){
            e.printStackTrace();
        }
        return department;
    }


    //add Department
    public Department addDepartment(Department fac){
        Department dep1=this.depRepository.save(fac);
        return  dep1;
    }

    //update Department
    public void updateDepartment(Department updatedDepartment, int deptId) {
        Department existingDepartment = depRepository.findById(deptId);

        if (existingDepartment != null) {
            // Update the existing department with the new data
            existingDepartment.setDeptName(updatedDepartment.getDeptName());
            existingDepartment.setRemarks(updatedDepartment.getRemarks());

            // Create a new Faculty or retrieve an existing one based on your requirements
            Faculty faculty = updatedDepartment.getFaculty();
            Faculty existingFaculty = null;

            if (faculty != null && faculty.getFacId() > 0) {
                existingFaculty = facRepository.findById(faculty.getFacId());
            }

        // Set the Faculty for the Department
        existingDepartment.setFaculty(faculty);

         // Save the updated Department
         depRepository.save(existingDepartment);
        }
    }//END UPDATE DEPARTMENT


    @Override
    @Transactional
    public void deleteDepartment(int id) {
        depRepository.deleteById(id);
    }



}
