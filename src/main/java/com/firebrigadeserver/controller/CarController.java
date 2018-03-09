package com.firebrigadeserver.controller;

import com.firebrigadeserver.entity.Car;
import com.firebrigadeserver.service.ICarService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("car")
public class CarController {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private ICarService carService;

    @GetMapping("car/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable Integer id) {
        Car car = carService.getCarById(id);
        return new ResponseEntity<Car>(car, HttpStatus.OK);
    }

    @GetMapping("cars")
    public ResponseEntity<List<Car>> getAllCars() {
        List<Car> list = carService.getAllCars();
        return new ResponseEntity<List<Car>>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "car", method = RequestMethod.POST)
    public ResponseEntity<Void> addCar(@RequestBody Car car) {
        try {
            carService.addCar(car);
        } catch (Exception e) {
            logger.error("Blad przy dodawaniu samochodu", e.getMessage());
        }
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @RequestMapping(value = "car", method = RequestMethod.PUT)
    public ResponseEntity<Car> updateCar(@RequestBody Car car) {
        carService.updateCar(car);
        return new ResponseEntity<Car>(car, HttpStatus.OK);
    }

    @RequestMapping(value = "del/{id}")
    public ResponseEntity<Void> deleteCar(@PathVariable Integer id) {
        carService.deleteCar(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
