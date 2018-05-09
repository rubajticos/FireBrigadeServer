package com.firebrigadeserver.controller;

import com.firebrigadeserver.dto.CarDTO;
import com.firebrigadeserver.dto.mapper.CarMapper;
import com.firebrigadeserver.dto.mapper.FireBrigadeMapper;
import com.firebrigadeserver.entity.Car;
import com.firebrigadeserver.entity.FireBrigade;
import com.firebrigadeserver.service.ICarService;
import com.firebrigadeserver.service.IFireBrigadeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CarController {
    public final static String TAG = "CarController";
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private ICarService carService;

    @Autowired
    private IFireBrigadeService fireBrigadeService;

    @Autowired
    private CarMapper carMapper;

    @Autowired
    private FireBrigadeMapper fireBrigadeMapper;

    @GetMapping("car/{id}")
    public ResponseEntity getCarById(@PathVariable Integer id) {
        Car car = carService.getCarById(id);

        if (car != null) {
            CarDTO carDTO = carMapper.entityToDto(car);
            logger.debug(TAG, "called getting car by ID");
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(carDTO);
        }

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(null);
    }

    @GetMapping("cars")
    public ResponseEntity getAllCars() {
        List<Car> cars = carService.getAllCars();

        if (cars.size() > 0) {
            List<CarDTO> carsDTO = carMapper.entityListToDtoList(cars);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(carsDTO);
        }

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(null);

    }

    @GetMapping("cars/{fireBrigadeId}")
    public ResponseEntity getCarsForFireBrigade(@PathVariable Integer fireBrigadeId) {
        List<Car> cars = carService.getCarsByFireBrigade(fireBrigadeId);
        if (cars.size() > 0) {
            List<CarDTO> carsDTO = carMapper.entityListToDtoList(cars);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(carsDTO);
        }

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(null);
    }


    @RequestMapping(value = "car/firebrigade/{fireBrigadeId}", method = RequestMethod.POST)
    public ResponseEntity addCar(@RequestBody CarDTO carDTO, @PathVariable Integer fireBrigadeId) {
        try {
            FireBrigade fireBrigade = fireBrigadeService.getFireBrigadeById(fireBrigadeId);
            if (fireBrigade != null) {
                Car candidateCar = carMapper.dtoToEntity(carDTO);
                candidateCar.setFireBrigade(fireBrigade);
                candidateCar = carService.addCar(candidateCar);
                if (candidateCar != null) {
                    CarDTO addedCar = carMapper.entityToDto(candidateCar);
                    return ResponseEntity
                            .status(HttpStatus.OK)
                            .body(addedCar);
                } else {
                    return ResponseEntity
                            .status(HttpStatus.CONFLICT)
                            .body(null);
                }
            }
        } catch (Exception e) {
            logger.debug(TAG, "Error when addind a car");
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(null);
        }

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(null);

    }

    @RequestMapping(value = "car", method = RequestMethod.PUT)
    public ResponseEntity updateCar(@RequestBody CarDTO carDto) {
        Car car = carMapper.dtoToEntity(carDto);
        car = carService.updateCar(car);
        if (car != null) {
            CarDTO updatedCar = carMapper.entityToDto(car);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(updatedCar);
        }

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(null);
    }

    @RequestMapping(value = "car/{carId}", method = RequestMethod.DELETE)
    public ResponseEntity deleteCar(@PathVariable Integer carId) {
        carService.deleteCar(carId);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(null);
    }
}
