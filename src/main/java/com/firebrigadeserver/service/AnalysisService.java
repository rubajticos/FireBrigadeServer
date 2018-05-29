package com.firebrigadeserver.service;

import com.firebrigadeserver.dto.additional.IncidentFull;
import com.firebrigadeserver.entity.CarIncident;
import com.firebrigadeserver.entity.Equipment;
import com.firebrigadeserver.entity.FireBrigade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import weka.associations.Apriori;
import weka.core.Attribute;
import weka.core.DenseInstance;
import weka.core.Instance;
import weka.core.Instances;

import java.util.ArrayList;
import java.util.List;

@Service
public class AnalysisService implements IAnalysisService {

    @Autowired
    private IncidentService incidentService;

    @Override
    public void basicAnalysis(FireBrigade fireBrigade) {
        Instances data;

        ArrayList<Attribute> atts = new ArrayList<Attribute>();

        List<String> myBooleanValues = new ArrayList<>(1);
        myBooleanValues.add("true");

        atts.add(new Attribute("Sprzęt pożarniczy", myBooleanValues));
        atts.add(new Attribute("Sprzęt ratowniczy", myBooleanValues));
        atts.add(new Attribute("Sprzęt ochrony osobistej", myBooleanValues));
        atts.add(new Attribute("Pozostałe", myBooleanValues));


        List<String> myNominalValues = new ArrayList<>(5);
        myNominalValues.add("Pożar");
        myNominalValues.add("Miejscowe zagrożenie");
        myNominalValues.add("Ćwiczenia");
        myNominalValues.add("Fałszywy alarm");
        myNominalValues.add("Zabezpieczenie rejonu operacyjnego");

        atts.add(new Attribute("typeOfIncident", myNominalValues));
        System.out.println("Attr type: " + atts.get(4).type());


        data = new Instances("MyFirebrigade", atts, 0);
        data.setClassIndex(data.numAttributes() - 1);

        int numAttributes = data.numAttributes();


        List<IncidentFull> incidents = incidentService.getIncidentsByFireBrigade(fireBrigade);

        for (IncidentFull incidentFull : incidents) {
            String incidentType = incidentFull.getIncident().getType();

            Instance instance = new DenseInstance(numAttributes);

            for (int i = 0; i < numAttributes - 1; i++) {
                String attributeName = data.attribute(i).name();
                for (CarIncident carIncident : incidentFull.getCars()) {
                    for (Equipment equipment : carIncident.getUsedEquipments()) {
                        if (equipment.getType().equals(attributeName)) instance.setValue(atts.get(i), "true");
                    }
                }
            }
            System.out.println("#########dupa: " + incidentType);
            instance.setValue(atts.get(numAttributes - 1), incidentType);
            data.add(instance);
        }


//        1
        Instance inst = new DenseInstance(numAttributes);

        inst.setValue(atts.get(0), "true");
        inst.setValue(atts.get(1), "true");
        inst.setValue(atts.get(2), "true");
        inst.setValue(atts.get(4), "Pożar");
        data.add(inst);


        System.out.println("Data");
        System.out.println(data.toString());

        Apriori apriori = new Apriori();
        try {
            apriori.buildAssociations(data);
            System.out.println(apriori);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
