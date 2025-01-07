package com.internshala.internshala.Controller;


import com.internshala.internshala.Dto.CarDetailsDTO;
import com.internshala.internshala.Service.Impl.CarServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("")
public class Controller {
@Autowired
    private CarServiceImplementation carServiceImplementation;


@GetMapping("welcome")
    public String welcome(){
        return "hello";

}

@PostMapping("add")
    public ResponseEntity<CarDetailsDTO> addCar(@RequestBody CarDetailsDTO carDetailsDTO){
    CarDetailsDTO carDetailsDTO1 = carServiceImplementation.addCar(carDetailsDTO);
return new ResponseEntity<>(carDetailsDTO1, HttpStatus.CREATED);


}

@DeleteMapping("delete/{id}")
    public String deleteCar(@PathVariable Long id){
carServiceImplementation.deleteCar(id);
return "deleted";

}
    @PutMapping("update/{id}")
    public ResponseEntity<CarDetailsDTO> updateCar(
            @RequestBody CarDetailsDTO carDetailsDTO,
            @PathVariable Long id) {
        CarDetailsDTO carDetailsDTO1 = carServiceImplementation.updateCar(carDetailsDTO, id);
        return new ResponseEntity<>(carDetailsDTO1, HttpStatus.CREATED);
    }


@GetMapping("all")
    public List<CarDetailsDTO> getAll(){
    return carServiceImplementation.viewAll();
}
}
