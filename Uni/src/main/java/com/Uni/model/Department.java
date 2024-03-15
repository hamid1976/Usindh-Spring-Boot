package com.Uni.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int deptId;
    private String  deptName;
    private String remarks;

    @ManyToOne
    @JoinColumn(name="fac_id")
    private Faculty faculty;

    public Department() {
    }

    public Department(int deptId, String deptName, String remarks, Faculty faculty) {
        this.deptId = deptId;
        this.deptName = deptName;
        this.remarks = remarks;
        this.faculty = faculty;
    }

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

}
