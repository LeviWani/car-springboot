package com.internshala.internshala.Repo;

import com.internshala.internshala.Dto.CarDetailsDTO;
import com.internshala.internshala.Entities.CarDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface Repo extends JpaRepository<CarDetails, Long> {
    @Query("SELECT new com.internshala.internshala.Dto.CarDetailsDTO(c.carName, c.carModel, c.year, c.price, c.color, c.fuel_type) " +
            "FROM CarDetails c " +
            "WHERE LOWER(c.carName) LIKE LOWER(CONCAT('%', :value, '%')) " +
            "OR LOWER(c.carModel) LIKE LOWER(CONCAT('%', :value, '%')) " +
            "OR CAST(c.year AS string) = :value")
    List<CarDetailsDTO> findByCarNameOrCarModelOrYear(String value);




    @Query("SELECT c FROM CarDetails c WHERE " +
            "LOWER(c.carModel) LIKE LOWER(CONCAT('%', :value, '%')) OR " +
            "LOWER(c.carName) LIKE LOWER(CONCAT('%', :value, '%')) OR " +
            "LOWER(c.color) LIKE LOWER(CONCAT('%', :value, '%')) OR " +
            "CAST(c.price AS string) = :value OR " +
            "CAST(c.year AS string) = :value OR " +
            "LOWER(CAST(c.fuel_type AS string)) LIKE LOWER(CONCAT('%', :value, '%'))")
    List<CarDetails> globalSearch(@Param("value") String value);







}
