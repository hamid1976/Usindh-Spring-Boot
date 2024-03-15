package com.Uni.repo;

import com.Uni.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepRepository extends JpaRepository<Department,Integer> {

    public Department findById(int id);

    public void deleteById(int id);

}
