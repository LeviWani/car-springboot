package com.internshala.internshala.Dto;


import com.internshala.internshala.FuelType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Data
@Getter
@Setter
public class CarDetailsDTO {


    private String car_model ;

    private String car_name;

    private int year;
    private int price;
    private String color ;
    private FuelType fuel_type;
}
