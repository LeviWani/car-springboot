package com.internshala.internshala.Repo;

import com.internshala.internshala.Entities.CarDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Repo extends JpaRepository<CarDetails,Long> {
}
