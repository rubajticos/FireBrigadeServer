package com.firebrigadeserver.controller;

import com.firebrigadeserver.entity.FireBrigade;
import com.firebrigadeserver.service.AnalysisService;
import com.firebrigadeserver.service.FireBrigadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AnalysisController {

    @Autowired
    private AnalysisService analysisService;

    @Autowired
    private FireBrigadeService fireBrigadeService;

    @GetMapping("/analysis/fireBrigadeId/{id}")
    public void getBasicAnalysis(@PathVariable int id) {
        FireBrigade fireBrigade = fireBrigadeService.getFireBrigadeById(id);
        analysisService.basicAnalysis(fireBrigade);
    }


}
