package com.internshala.internshala.Service.Interface;

import com.internshala.internshala.Dto.CarDetailsDTO;

import java.util.List;

public interface Car_Interface {
    CarDetailsDTO addCar(CarDetailsDTO carDetailsDTO);
    List<CarDetailsDTO> viewAll();
    String deleteCar(Long id);
    CarDetailsDTO updateCar(CarDetailsDTO carDetailsDTO, long id);



}
