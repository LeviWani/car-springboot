package com.internshala.internshala.Service.Impl;

import com.internshala.internshala.Dto.CarDetailsDTO;
import com.internshala.internshala.Entities.CarDetails;
import com.internshala.internshala.Mapper.CarMapper;
import com.internshala.internshala.Repo.Repo;
import com.internshala.internshala.Service.Interface.Car_Interface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

        List<CarDetails> cars = repo.findAll();
        return cars.stream().map((temp)->carMapper.toDto(temp)).toList();


    }

    public Page<CarDetails> viewAllPagination(int offset, int pagesize) {
        Page<CarDetails> page = repo.findAll(PageRequest.of(offset, pagesize));
return page;

    }
    public List<CarDetails> viewAllSorting(String field) {

        return repo.findAll(Sort.by(Sort.Direction.ASC, field));


    }


    @Override
    public String deleteCar(Long id ) {
        CarDetails carDetails = repo.findById(id).orElseThrow();
        repo.delete(carDetails);
        return "deleted car";
    }

    @Override
    public CarDetailsDTO updateCar(CarDetailsDTO carDetailsDTO, long id) {
       CarDetails carDetails = repo.findById(id).orElseThrow();

        carDetails.setCarName(carDetailsDTO.getCarName());
        carDetails.setCarModel(carDetailsDTO.getCarModel());
        carDetails.setYear(carDetailsDTO.getYear());
        carDetails.setFuel_type(carDetailsDTO.getFuel_type());
        carDetails.setColor(carDetailsDTO.getColor());
        carDetails.setPrice(carDetailsDTO.getPrice());
        repo.save(carDetails);

        return  carMapper.toDto(carDetails);

    }


    public String deleteEntry(long id){
        repo.deleteById(id);
        return "deleted";

    }

    public  List<CarDetailsDTO> globalSearch(String value){
        List<CarDetails> results = repo.globalSearch(value);
        System.out.println("Results: " + results);

        // return cars.stream().map((temp)->carMapper.toDto(temp)).toList();



        return results.stream().map((temp)->carMapper.toDto(temp)).toList();
    }




    public List<CarDetailsDTO> filter(String value) {
        return repo.findByCarNameOrCarModelOrYear(value);
    }

}
