package com.internshala.internshala.Config;

import com.internshala.internshala.Mapper.CarMapper;
import com.internshala.internshala.Service.Impl.CarServiceImplementation;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class AppConfig {

    @Bean
public ModelMapper modelMapper(){
        return  new ModelMapper();
    }

    @Bean
    public CarMapper carMapper(){
        return  new CarMapper();
    }

    @Bean
    public CarServiceImplementation carServiceImplementation(){
        return new  CarServiceImplementation();
    }

}
