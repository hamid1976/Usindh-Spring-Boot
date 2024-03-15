package com.Uni.repo;

import com.Uni.model.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;


public interface FacRepository extends JpaRepository<Faculty,Integer> {

    public Faculty findById(int id);
}
