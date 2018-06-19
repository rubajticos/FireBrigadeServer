package com.firebrigadeserver.controller;

import com.firebrigadeserver.entity.FireBrigade;
import com.firebrigadeserver.service.AnalysisService;
import com.firebrigadeserver.service.FireBrigadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class AnalysisController {

    @Autowired
    private AnalysisService analysisService;

    @Autowired
    private FireBrigadeService fireBrigadeService;

    @GetMapping("/analysis/main/fireBrigadeId/{id}")
    public void getMainTypesIncidentAndEquipmentAnalysis(@PathVariable int id) {
        FireBrigade fireBrigade = fireBrigadeService.getFireBrigadeById(id);
        try {
            analysisService.analyseMainTypesOfIncidentAndMainTypesOfEquipment(fireBrigade, false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/analysis/detail/fireBrigadeId/{id}")
    public void getDetailTypesIncidentAndEquipmentAnalysis(@PathVariable int id) {
        FireBrigade fireBrigade = fireBrigadeService.getFireBrigadeById(id);
        try {
            analysisService.analyseDetailTypesOfIncidentAndDetailTypesOfEquipment(fireBrigade, false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/analysis/main/fireBrigadeId/{id}/simple")
    public void getMainTypesIncidentAndEquipmentAnalysisAndSimpleReport(@PathVariable int id) {
        FireBrigade fireBrigade = fireBrigadeService.getFireBrigadeById(id);
        try {
            analysisService.analyseMainTypesOfIncidentAndMainTypesOfEquipment(fireBrigade, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/analysis/detail/fireBrigadeId/{id}/simple")
    public void getDetailTypesIncidentAndEquipmentAnalysisAndSimpleReport(@PathVariable int id) {
        FireBrigade fireBrigade = fireBrigadeService.getFireBrigadeById(id);
        try {
            analysisService.analyseDetailTypesOfIncidentAndDetailTypesOfEquipment(fireBrigade, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
