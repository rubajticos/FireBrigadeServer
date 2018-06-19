package com.firebrigadeserver.service;

import com.firebrigadeserver.entity.FireBrigade;

import java.io.IOException;

public interface IAnalysisService {

    void analyseMainTypesOfIncidentAndMainTypesOfEquipment(FireBrigade fireBrigade, boolean basicReport) throws IOException;

    void analyseDetailTypesOfIncidentAndDetailTypesOfEquipment(FireBrigade fireBrigade, boolean basicReport) throws IOException;

}
