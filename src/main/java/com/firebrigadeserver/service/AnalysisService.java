package com.firebrigadeserver.service;

import com.firebrigadeserver.analysis.AnalysisMethods;
import com.firebrigadeserver.dto.additional.IncidentFull;
import com.firebrigadeserver.entity.FireBrigade;
import com.firebrigadeserver.pdf.ITextStamperSample;
import com.itextpdf.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class AnalysisService implements IAnalysisService {

    @Autowired
    private IncidentService incidentService;

    @Autowired
    private SimpleDateFormat simpleDateFormat;

    @Override
    public void analyseMainTypesOfIncidentAndMainTypesOfEquipment(FireBrigade fireBrigade, boolean basicReport) throws IOException {
        List<IncidentFull> listOfIncidents = incidentService.getIncidentsByFireBrigade(fireBrigade);

        String analysisDescription = "Analiza została przeprowadzona w celu wyznaczenia reguł asocjacyjnych" +
                "na podstawie zdarzeń strażakich. Do jej przeprowadzenia użyto danych operacyjnych z jednostki " + fireBrigade.getName() +
                ".\n Analiza wyznacza reguły acocjacyjne bazując na głównych kategoriach zdarzeń i użytego sprzętu";

        List<String> results = AnalysisMethods.analyzeMainTypesOfIncidentAndEquipment(listOfIncidents, basicReport);

        String date = simpleDateFormat.format(new Date());
        String fileName = "fileName";
        if (basicReport) {
            fileName = date + "_main_analysis_simple_report";
        } else {
            fileName = date + "_main_analysis";

        }

        try {
            ITextStamperSample.generatePdfForAnalysis(fileName, fireBrigade.getName(), analysisDescription, results.get(0), results.get(1));
        } catch (DocumentException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }


    }

    @Override
    public void analyseDetailTypesOfIncidentAndDetailTypesOfEquipment(FireBrigade fireBrigade, boolean basicReport) throws IOException {
        List<IncidentFull> listOfIncidents = incidentService.getIncidentsByFireBrigade(fireBrigade);

        String analysisDescription = "Analiza została przeprowadzona w celu wyznaczenia reguł asocjacyjnych" +
                "na podstawie wyjazdów ratowniczych. Do jej przeprowadzenia użyto danych operacyjnych z jednostki " + fireBrigade.getName() +
                ".\n Analiza wyznacza reguły acocjacyjne bazując na szczegółowych kategoriach zdarzeń i użytego sprzętu";

        List<String> results = AnalysisMethods.analyzeDetailTypesOfIncidentAndEquipment(listOfIncidents, basicReport);
        String date = simpleDateFormat.format(new Date());
        String fileName = "fileName";
        if (basicReport) {
            fileName = date + "_detail_analysis_simple_report";

        } else {
            fileName = date + "_detail_analysis";

        }

        try {
            ITextStamperSample.generatePdfForAnalysis(fileName, fireBrigade.getName(), analysisDescription, results.get(0), results.get(1));
        } catch (DocumentException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

    }
}
