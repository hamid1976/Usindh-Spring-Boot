package com.Uni.service.Impl;

import com.Uni.model.Faculty;
import com.Uni.repo.FacRepository;
import com.Uni.service.FacService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FacultyServiceImpl implements FacService {

    @Autowired
    private FacRepository facRepository;


    //get All Faculty
    public List<Faculty> getAllFaculty(){
        List<Faculty> list=this.facRepository.findAll();
        return list;
    }
    //get Faculty By Id
    public Faculty getFacultyById(int facId){
        Faculty faculty=null;
        try{

            faculty= this.facRepository.findById(facId);
        }catch(Exception e){
            e.printStackTrace();
        }
        return faculty;
    }
    //add faculty
    public Faculty addFaculty(Faculty fac){
        Faculty fac1=this.facRepository.save(fac);
        return  fac1;
    }

    //update Faculty
    public Faculty updateFaculty(Faculty faculty, int facId){
        faculty.setFacId(facId);
        facRepository.save(faculty);
        return faculty;
    }

    //delete Faculty
    public void deleteFaculty(int facId){
        this.facRepository.deleteById(facId);
    }


}
