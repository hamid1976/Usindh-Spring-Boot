package com.Uni.controller;


import com.Uni.model.Department;
import com.Uni.model.Faculty;
import com.Uni.service.FacService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/faculty")
public class FacultyController {

    @Autowired
    private FacService facService;

    //get All Faculty

    @GetMapping("/")
    public ResponseEntity<List<Faculty>> getAllFaculty(){

        List<Faculty>list= this.facService.getAllFaculty();

        if(list.size()<=0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(list);
    }//get all faculty

    @GetMapping("/{facId}")
    public Faculty getFaculty(@PathVariable("facId")int facId){
        return this.facService.getFacultyById(facId);
    }

    @PostMapping("/")
    public ResponseEntity<Faculty> addFaculty(@RequestBody Faculty faculty) {

        Faculty f = null;
        try {
            f = this.facService.addFaculty(faculty);
            System.out.println(faculty);
            return ResponseEntity.of(Optional.of(f));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    //update the faculty
    @PutMapping("/{facId}")
    public ResponseEntity<Faculty> updateFaculty(@RequestBody Faculty faculty,@PathVariable
            ("facId")int facId){

        try {
            this.facService.updateFaculty(faculty, facId);
            return ResponseEntity.ok().body(faculty);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }//end updateStudent

    //delete user by id
    @DeleteMapping("/{facId}")
    public void deleteFaculty(@PathVariable("facId")int facId){
        try{
            this.facService.deleteFaculty(facId);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}



//package com.Uni.controller;
//
//import com.Uni.model.Faculty;
//import com.Uni.service.FacService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/faculty")
//public class FacultyController {
//
//    @Autowired
//    private FacService facService;
//
//    //get All Faculty
//    @GetMapping("/")
//    public ResponseEntity<List<Faculty>> getAllFaculty() {
//        try {
//            List<Faculty> list = this.facService.getAllFaculty();
//
//            if (list.size() <= 0) {
//                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//            }
//            return ResponseEntity.status(HttpStatus.CREATED).body(list);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//        }
//    }//get all faculty
//
//    @GetMapping("/{facId}")
//    public ResponseEntity<Faculty> getFaculty(@PathVariable("facId") int facId) {
//        try {
//            Faculty faculty = this.facService.getFacultyById(facId);
//            if (faculty != null) {
//                return ResponseEntity.ok().body(faculty);
//            } else {
//                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//        }
//    }
//
//    @PostMapping("/")
//    public ResponseEntity<Faculty> addFaculty(@RequestBody Faculty faculty) {
//        try {
//            Faculty addedFaculty = this.facService.addFaculty(faculty);
//            return ResponseEntity.status(HttpStatus.CREATED).body(addedFaculty);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//        }
//    }
//
//    //update the faculty
//    @PutMapping("/{facId}")
//    public ResponseEntity<Faculty> updateFaculty(@RequestBody Faculty faculty, @PathVariable("facId") int facId) {
//        try {
//            Faculty updatedFaculty = this.facService.updateFaculty(faculty, facId);
//            return ResponseEntity.ok().body(updatedFaculty);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//        }
//    }//end updateStudent
//
//    //delete user by id
//    @DeleteMapping("/{facId}")
//    public ResponseEntity<String> deleteFaculty(@PathVariable("facId") int facId) {
//        try {
//            this.facService.deleteFaculty(facId);
//            return ResponseEntity.ok().body("Faculty deleted successfully");
//        } catch (Exception e) {
//            e.printStackTrace();
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting faculty");
//        }
//    }
//}
