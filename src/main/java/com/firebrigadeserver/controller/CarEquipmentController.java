package com.firebrigadeserver.controller;

import com.firebrigadeserver.dto.CarEquipmentDTO;
import com.firebrigadeserver.dto.mapper.CarEquipmentMapper;
import com.firebrigadeserver.entity.CarEquipment;
import com.firebrigadeserver.service.ICarEquipmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CarEquipmentController {
    public final static String TAG = "CarEquipment Controller";

    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private ICarEquipmentService carEquipmentService;

    @Autowired
    private CarEquipmentMapper carEquipmentMapper;

    @GetMapping("car/{carId}/equipment/active")
    public ResponseEntity getActiveCarEquipment(@PathVariable Integer carId) {
        List<CarEquipment> carEquipmentList = carEquipmentService.getActiveCarEquipmentForCar(carId);
        if (carEquipmentList.size() > 0) {
            List<CarEquipmentDTO> carEquipmentDTOList = carEquipmentMapper.entityListToDtoList(carEquipmentList);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(carEquipmentDTOList);
        }

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(null);
    }

    @GetMapping("car/{carId}/equipment/disactive")
    public ResponseEntity getDisactiveCarEquipment(@PathVariable Integer carId) {
        List<CarEquipment> carEquipmentList = carEquipmentService.getWithdrawalCarEquipmentForCar(carId);
        if (carEquipmentList.size() > 0) {
            List<CarEquipmentDTO> carEquipmentDTOList = carEquipmentMapper.entityListToDtoList(carEquipmentList);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(carEquipmentDTOList);
        }

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(null);
    }

    @GetMapping("equipment/{equipmentId}/car")
    public ResponseEntity getCarEquipmentForEquipment(@PathVariable Integer equipmentId) {
        CarEquipment carEquipment = carEquipmentService.getActiveCarEquipmentForEquipment(equipmentId);
        if (carEquipment != null) {
            CarEquipmentDTO carEquipmentDTO = carEquipmentMapper.entityToDto(carEquipment);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(carEquipmentDTO);
        }

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(null);
    }


    @RequestMapping(value = "car/equipment", method = RequestMethod.POST)
    public ResponseEntity addCarEquipment(@RequestBody CarEquipmentDTO carEquipmentDTO) {
        CarEquipment candidateCarEquipment = carEquipmentMapper.dtoToEntity(carEquipmentDTO);
        candidateCarEquipment = carEquipmentService.addCarEquipment(candidateCarEquipment);
        if (candidateCarEquipment != null) {
            CarEquipmentDTO createdCarEquipment = carEquipmentMapper.entityToDto(candidateCarEquipment);
            logger.debug(TAG, "pomyslnie dodano sprzet do samochodu");
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(createdCarEquipment);
        }
        logger.debug(TAG, "nie dodano sprzetu do samochodu");
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(null);
    }

    @RequestMapping(value = "car/equipment", method = RequestMethod.PUT)
    public ResponseEntity updateCarEquipment(@RequestBody CarEquipmentDTO carEquipmentDTO) {
        CarEquipment candidateCarEquipment = carEquipmentMapper.dtoToEntity(carEquipmentDTO);
        candidateCarEquipment = carEquipmentService.addCarEquipment(candidateCarEquipment);
        if (candidateCarEquipment != null) {
            CarEquipmentDTO updatedCarEquipment = carEquipmentMapper.entityToDto(candidateCarEquipment);
            logger.debug(TAG, "pomyslnie zaktualizowano sprzet samochodu");
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(updatedCarEquipment);
        }
        logger.debug(TAG, "nie zaktualizowano sprzetu samochodu");
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(null);
    }

    @RequestMapping(value = "car/equipment/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteCarEquipment(@PathVariable Integer id) {
        carEquipmentService.deleteCarEquipment(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(null);
    }


}
