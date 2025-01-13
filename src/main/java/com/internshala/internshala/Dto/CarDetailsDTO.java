package com.internshala.internshala.Dto;


import com.internshala.internshala.FuelType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class CarDetailsDTO {


    private java.lang.String carModel;

    private java.lang.String carName;

    private int year;
    private int price;
    private java.lang.String color ;
    @Enumerated(EnumType.STRING)
    private FuelType fuel_type;

    public java.lang.String getCarModel() {
        return carModel;
    }

    public void setCarModel(java.lang.String carModel) {
        this.carModel = carModel;
    }

    public java.lang.String getCarName() {
        return carName;
    }

    public void setCarName(java.lang.String carName) {
        this.carName = carName;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public java.lang.String getColor() {
        return color;
    }

    public void setColor(java.lang.String color) {
        this.color = color;
    }

    public FuelType getFuel_type() {
        return fuel_type;
    }

    public void setFuel_type(FuelType fuel_type) {
        this.fuel_type = fuel_type;
    }

    public CarDetailsDTO(String carModel, String carName, int year, int price, String color, FuelType fuel_type) {
        this.carModel = carModel;
        this.carName = carName;
        this.year = year;
        this.price = price;
        this.color = color;
        this.fuel_type = fuel_type;
    }

    public CarDetailsDTO() {

    }
}
