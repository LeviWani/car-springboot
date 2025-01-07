package com.internshala.internshala.Mapper;

import com.internshala.internshala.Dto.CarDetailsDTO;
import com.internshala.internshala.Entities.CarDetails;
import org.apache.catalina.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class CarMapper {
    @Autowired
    private ModelMapper mapper;

    public CarDetails toEntity(CarDetailsDTO carDetailsDTO){
        return mapper.map(carDetailsDTO, CarDetails.class);
    }

    public CarDetailsDTO toDto (CarDetails carDetails){
        return mapper.map(carDetails, CarDetailsDTO.class);
    }
}
