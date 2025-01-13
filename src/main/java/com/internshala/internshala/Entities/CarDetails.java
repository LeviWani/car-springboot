package com.internshala.internshala.Entities;


import com.internshala.internshala.FuelType;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="car_details")
@Data
public class CarDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long car_bd_id;

    private java.lang.String carModel;

    private java.lang.String carName;

    private int year;
    private int price;
    private java.lang.String color ;
    @Enumerated(EnumType.STRING)
    private FuelType fuel_type;

    public Long getCar_bd_id() {
        return car_bd_id;
    }

    public void setCar_bd_id(Long car_bd_id) {
        this.car_bd_id = car_bd_id;
    }

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

    @Override
    public java.lang.String toString() {
        return "CarDetails{" +
                "car_bd_id=" + car_bd_id +
                ", car_model='" + carModel + '\'' +
                ", car_name='" + carName + '\'' +
                ", year=" + year +
                ", price=" + price +
                ", color='" + color + '\'' +
                ", fuel_type=" + fuel_type +
                '}';
    }
}
