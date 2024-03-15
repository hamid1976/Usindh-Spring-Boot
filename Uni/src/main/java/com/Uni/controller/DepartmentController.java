package com.Uni.controller;

import com.Uni.model.Department;
import com.Uni.service.DepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/department")
public class DepartmentController {
        @Autowired
        private DepService depService;

        //get All Department
        @GetMapping("/")
        public ResponseEntity<List<Department>> getAllDepartment(){

            List<Department>list= this.depService.getAllDepartment();

            if(list.size()<=0){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
            return ResponseEntity.status(HttpStatus.CREATED).body(list);
        }//get all faculty


        //getDepartmentById
        @GetMapping("/{depId}")
        public Department getDepartment(@PathVariable("depId")int depId){
            return this.depService.getDepartmentById(depId);
        }

        //add Department
        @PostMapping("/")
        public ResponseEntity<Department> addDepartment(@RequestBody Department department) {

            Department f = null;
            try {
                f = this.depService.addDepartment(department);
                System.out.println(department);
                return ResponseEntity.of(Optional.of(f));
            } catch (Exception e) {
                e.printStackTrace();
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
        }

        //update the Department
        @PutMapping("/{depId}")
        public ResponseEntity<Department> updateFaculty(@RequestBody Department department,@PathVariable
                ("depId")int depId){

            try {
                this.depService.updateDepartment(department, depId);
                return ResponseEntity.ok().body(department);
            } catch (Exception e) {
                e.printStackTrace();
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
        }//end update Department

    @DeleteMapping("/{depId}")
    public ResponseEntity<Department> deleteDepartment(@PathVariable("depId") int depId) {
        try {
            depService.deleteDepartment(depId);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }





}
