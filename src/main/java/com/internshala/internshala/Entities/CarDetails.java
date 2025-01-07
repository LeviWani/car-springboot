package com.internshala.internshala.Entities;


import com.internshala.internshala.FuelType;
import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Table(name="car_details")
@Data
public class CarDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long car_bd_id;

    private String car_model ;

    private String car_name;

    private int year;
    private int price;
    private String color ;
    private FuelType fuel_type;

}
