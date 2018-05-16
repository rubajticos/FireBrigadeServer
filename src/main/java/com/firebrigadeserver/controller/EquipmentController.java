package com.firebrigadeserver.controller;

import com.firebrigadeserver.dto.EquipmentDTO;
import com.firebrigadeserver.dto.additional.EquipmentAdditional;
import com.firebrigadeserver.dto.mapper.EquipmentMapper;
import com.firebrigadeserver.dto.mapper.FireBrigadeMapper;
import com.firebrigadeserver.entity.Equipment;
import com.firebrigadeserver.entity.FireBrigade;
import com.firebrigadeserver.service.IEquipmentService;
import com.firebrigadeserver.service.IFireBrigadeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EquipmentController {
    public final static String TAG = "EquipmentController";
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private IEquipmentService equipmentService;

    @Autowired
    private IFireBrigadeService fireBrigadeService;

    @Autowired
    private EquipmentMapper equipmentMapper;

    @Autowired
    private FireBrigadeMapper fireBrigadeMapper;

    @GetMapping("equipment/{id}")
    public ResponseEntity getEquipmentById(@PathVariable Integer id) {
        Equipment equipment = equipmentService.getEquipmentById(id);

        if (equipment != null) {
            EquipmentDTO equipmentDTO = equipmentMapper.entityToDto(equipment);
            logger.debug(TAG, "called getting equipment by ID");
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(equipmentDTO);
        }

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(null);
    }

    @GetMapping("equipments")
    public ResponseEntity getAllEquipments() {
        List<Equipment> equipmentList = equipmentService.getAllEquipment();

        if (equipmentList.size() > 0) {
            List<EquipmentDTO> equipmentDTOList = equipmentMapper.entityListToDtoList(equipmentList);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(equipmentDTOList);
        }

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(null);
    }

    @GetMapping("equipments/firebrigade/{fireBrigadeId}")
    public ResponseEntity getEquipmentsForFireBrigade(@PathVariable Integer fireBrigadeId) {
        List<Equipment> equipmentList = equipmentService.getEquipmentsByFireBrigade(fireBrigadeId);
        if (equipmentList.size() > 0) {
            List<EquipmentDTO> equipmentDTOList = equipmentMapper.entityListToDtoList(equipmentList);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(equipmentDTOList);
        }

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(null);
    }

    @GetMapping("equipments/firebrigade/{fireBrigadeId}/additional")
    public ResponseEntity getActiveEquipmentsAdditionalForFireBrigade(@PathVariable Integer fireBrigadeId) {
        List<EquipmentAdditional> equipmentAdditionalList = equipmentService.getActiveEquipmentsByFireBrigadeWithCarNames(fireBrigadeId);
        if (equipmentAdditionalList.size() > 0) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(equipmentAdditionalList);
        }

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(null);
    }

    @RequestMapping(value = "equipment/fireBrigade/{fireBrigadeId}", method = RequestMethod.POST)
    public ResponseEntity addEquipment(@RequestBody EquipmentDTO equipmentDTO, @PathVariable Integer fireBrigadeId) {
        FireBrigade fireBrigade = fireBrigadeService.getFireBrigadeById(fireBrigadeId);
        if (fireBrigade != null) {
            Equipment candidateEquipment = equipmentMapper.dtoToEntity(equipmentDTO);
            candidateEquipment.setFireBrigade(fireBrigade);
            candidateEquipment = equipmentService.addEquipment(candidateEquipment);
            if (candidateEquipment != null) {
                EquipmentDTO addedEquipment = equipmentMapper.entityToDto(candidateEquipment);
                return ResponseEntity
                        .status(HttpStatus.OK)
                        .body(addedEquipment);
            }
        }

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(null);
    }

    @RequestMapping(value = "equipment", method = RequestMethod.PUT)
    public ResponseEntity updateEquipment(@RequestBody EquipmentDTO equipmentDto) {
        Equipment equipment = equipmentMapper.dtoToEntity(equipmentDto);
        equipment = equipmentService.updateEquipment(equipment);
        if (equipment != null) {
            EquipmentDTO updatedEquipment = equipmentMapper.entityToDto(equipment);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(updatedEquipment);
        }

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(null);
    }

    @RequestMapping(value = "equipment/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteEquipment(@PathVariable Integer id) {
        equipmentService.deleteEquipment(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(null);
    }

}
