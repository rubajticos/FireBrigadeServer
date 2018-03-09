package com.firebrigadeserver.controller;

import com.firebrigadeserver.entity.Equipment;
import com.firebrigadeserver.service.IEquipmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EquipmentController {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private IEquipmentService equipmentService;

    @GetMapping("equipment/{id}")
    public ResponseEntity<Equipment> getEquipmentById(@PathVariable Integer id) {
        Equipment equipment = equipmentService.getEquipmentById(id);
        return new ResponseEntity<Equipment>(equipment, HttpStatus.OK);
    }

    @GetMapping("equipments")
    public ResponseEntity<List<Equipment>> getAllEquipments() {
        List<Equipment> list = equipmentService.getAllEquipment();
        return new ResponseEntity<List<Equipment>>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "equipment", method = RequestMethod.POST)
    public ResponseEntity<Void> addEquipment(@RequestBody Equipment equipment) {
        try {
            equipmentService.addEquipment(equipment);
        } catch (Exception e) {
            logger.error("Blad przy dodawaniu sprzetu", e.getMessage());
        }

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @RequestMapping(value = "equipment", method = RequestMethod.PUT)
    public ResponseEntity<Equipment> updateEquipment(@RequestBody Equipment equipment) {
        equipmentService.updateEquipment(equipment);
        return new ResponseEntity<Equipment>(equipment, HttpStatus.OK);
    }

    @RequestMapping(value = "equipment/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteEquipment(@PathVariable Integer id) {
        equipmentService.deleteEquipment(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

}
