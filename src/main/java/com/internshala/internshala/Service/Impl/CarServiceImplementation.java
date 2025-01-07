package com.internshala.internshala.Service.Impl;

import com.internshala.internshala.Dto.CarDetailsDTO;
import com.internshala.internshala.Entities.CarDetails;
import com.internshala.internshala.Mapper.CarMapper;
import com.internshala.internshala.Repo.Repo;
import com.internshala.internshala.Service.Interface.Car_Interface;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImplementation implements Car_Interface {

    @Autowired
    private Repo repo;
    @Autowired
    private CarMapper carMapper;
    @Override
    public CarDetailsDTO addCar(CarDetailsDTO carDetailsDTO1) {
        CarDetails temp = carMapper.toEntity(carDetailsDTO1);
        CarDetails saved =repo.save(temp);
        return carMapper.toDto(saved);
    }

    @Override
    public List<CarDetailsDTO> viewAll() {
       // return List.of();

        //List<Expense> expenses = expenseRepo.findAll();
        //    return expenses.stream().map((temp)->expenseMapper.expenseToExpenseDto(temp)).toList();
        List<CarDetails> cars = repo.findAll();
        return cars.stream().map((temp)->carMapper.toDto(temp)).toList();


    }

    @Override
    public String deleteCar(Long id ) {
        CarDetails carDetails = repo.findById(id).orElseThrow();
        repo.delete(carDetails);
        return "deleted car";
    }

    @Override
    public CarDetailsDTO updateCar(CarDetailsDTO carDetailsDTO, Long id) {
       CarDetails carDetails = repo.findById(id).orElseThrow();
/*
        carDetails.setCar_name(carDetailsDTO.getCar_name());
       // carDetails.setCar_model(carDetailsDTO.getCar_model());
        carDetails.setYear(carDetailsDTO.getYear());
        carDetails.setFuel_type(carDetailsDTO.getFuel_type());
        carDetails.setColor(carDetailsDTO.getColor());
        carDetails.setPrice(carDetailsDTO.getPrice());
*/

        return  carMapper.toDto(carDetails);

    }
}
