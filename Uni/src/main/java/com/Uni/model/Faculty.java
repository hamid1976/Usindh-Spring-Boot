package com.Uni.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Faculty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int facId;
    private String facName;
    private String remarks;

    @OneToMany(mappedBy = "faculty",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Department> department;

    public Faculty() {
    }

    public Faculty(int facId, String facName, String remarks, List<Department> department) {
        this.facId = facId;
        this.facName = facName;
        this.remarks = remarks;
        this.department = department;
    }


    public int getFacId() {
        return facId;
    }

    public void setFacId(int facId) {
        this.facId = facId;
    }

    public String getFacName() {
        return facName;
    }

    public void setFacName(String facName) {
        this.facName = facName;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remakrs) {
        this.remarks = remakrs;
    }

    public List<Department> getDepartment() {
        return department;
    }

    public void setDepartment(List<Department> department) {
        this.department = department;
    }
}
