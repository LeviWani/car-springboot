package com.internshala.internshala.Controller;


import com.internshala.internshala.Dto.CarDetailsDTO;
import com.internshala.internshala.Entities.CarDetails;
import com.internshala.internshala.Service.Impl.CarServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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

    @GetMapping("all/{offset}/{pagesize}")
    public Page<CarDetails> getAllPagination(@PathVariable int offset, @PathVariable int pagesize){
        return carServiceImplementation.viewAllPagination(offset, pagesize);
    }

@GetMapping("all/{value}")
public List<CarDetailsDTO> getFilter(@PathVariable String value){
    return carServiceImplementation.filter(value);
}

    @GetMapping("sort/{value}")
    public List<CarDetails> getallSorting(@PathVariable String value){
        return carServiceImplementation.viewAllSorting(value);
    }

@DeleteMapping("md/{carModel}")
public void deleteModel(@PathVariable long id ){
carServiceImplementation.deleteEntry(id);
}


@GetMapping("global/{value}")
public ResponseEntity<List<CarDetailsDTO>> globalSearch(@PathVariable String value) {
    List<CarDetailsDTO> results = carServiceImplementation.globalSearch(value);
    if (results.isEmpty()) {
        return ResponseEntity.noContent().build();
    }
    return ResponseEntity.ok(results);
}


}