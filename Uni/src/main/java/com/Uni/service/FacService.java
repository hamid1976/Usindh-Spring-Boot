package com.Uni.service;

import com.Uni.model.Faculty;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface FacService {


    //get All Faculty
    public List<Faculty> getAllFaculty();

    //get faculty By fac id
    public Faculty getFacultyById(int id);

    //add faculty
    public Faculty addFaculty(Faculty faculty);

    //update faculty
    public Faculty updateFaculty(Faculty faculty, int id);

    //delete faculty by id
    public void deleteFaculty(int id);
}
