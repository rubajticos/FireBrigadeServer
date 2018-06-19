package com.firebrigadeserver.analysis;

import com.firebrigadeserver.dto.additional.IncidentFull;
import com.firebrigadeserver.entity.CarIncident;
import com.firebrigadeserver.entity.Equipment;
import weka.associations.Apriori;
import weka.associations.AssociationRule;
import weka.associations.AssociationRules;
import weka.associations.Item;
import weka.core.Attribute;
import weka.core.DenseInstance;
import weka.core.Instance;
import weka.core.Instances;

import java.util.ArrayList;
import java.util.List;

public class AnalysisMethods {


    public static List<String> analyzeMainTypesOfIncidentAndEquipment(List<IncidentFull> incidents, boolean simpleReport) {
        Instances dataSet;
        ArrayList<Attribute> attributes = new ArrayList<Attribute>();

        List<String> myBooleanValues = new ArrayList<>(1);
        myBooleanValues.add("true");

        attributes.add(new Attribute("Sprzęt pożarniczy", myBooleanValues));
        attributes.add(new Attribute("Sprzęt ratowniczy", myBooleanValues));
        attributes.add(new Attribute("Sprzęt ochrony osobistej", myBooleanValues));
        attributes.add(new Attribute("Pozostałe", myBooleanValues));


        List<String> myNominalValues = new ArrayList<>(5);
        myNominalValues.add("Pożar");
        myNominalValues.add("Miejscowe zagrożenie");
        myNominalValues.add("Ćwiczenia");
        myNominalValues.add("Fałszywy alarm");
        myNominalValues.add("Zabezpieczenie rejonu operacyjnego");

        attributes.add(new Attribute("Zdarzenie", myNominalValues));
        System.out.println("Attr type: " + attributes.get(4).type());

        dataSet = new Instances("Analiza ogólnego podziału zdarzeń i sprzętu", attributes, 0);
        dataSet.setClassIndex(dataSet.numAttributes() - 1);

        int numAttributes = dataSet.numAttributes();

        for (IncidentFull incidentFull : incidents) {
            String incidentType = incidentFull.getIncident().getType();

            Instance instance = new DenseInstance(numAttributes);

            for (int i = 0; i < numAttributes - 1; i++) {
                String attributeName = dataSet.attribute(i).name();
                for (CarIncident carIncident : incidentFull.getCars()) {
                    for (Equipment equipment : carIncident.getUsedEquipments()) {
                        if (equipment.getType().equals(attributeName)) instance.setValue(attributes.get(i), "true");
                    }
                }
            }
            instance.setValue(attributes.get(numAttributes - 1), incidentType);
            dataSet.add(instance);
        }

        Apriori apriori = new Apriori();
        try {
            apriori.buildAssociations(dataSet);
        } catch (Exception e) {
            e.printStackTrace();
        }

        List<String> result = new ArrayList<String>();

        if (!simpleReport) {
            result.add(dataSet.toSummaryString());
            result.add(apriori.toString());
        } else {
            result.add(buildSimpleDataInfo(dataSet));
            result.add(buildSimpleReport(apriori));
        }

        return result;
    }

    public static List<String> analyzeDetailTypesOfIncidentAndEquipment(List<IncidentFull> incidents, boolean simpleReport) {
        Instances dataSet;
        ArrayList<Attribute> attributes = new ArrayList<Attribute>();

        List<String> myBooleanValues = new ArrayList<>(1);
        myBooleanValues.add("true");

        attributes.add(new Attribute("Podręczny sprzęt gaśniczy", myBooleanValues));
        attributes.add(new Attribute("Sprzęt i armatura wodna", myBooleanValues));
        attributes.add(new Attribute("Pompy pożarnicze", myBooleanValues));
        attributes.add(new Attribute("Sprzęt tnący", myBooleanValues));
        attributes.add(new Attribute("Sprzęt burzący", myBooleanValues));
        attributes.add(new Attribute("Sprzęt podnoszący", myBooleanValues));
        attributes.add(new Attribute("Sprzęt rozpierający", myBooleanValues));
        attributes.add(new Attribute("Sprzęt ewakuujący", myBooleanValues));
        attributes.add(new Attribute("Sprzęt medyczny", myBooleanValues));
        attributes.add(new Attribute("Oznakowanie terenu", myBooleanValues));
        attributes.add(new Attribute("Podręczny sprzęt", myBooleanValues));


        List<String> myNominalValues = new ArrayList<>(5);
        myNominalValues.add("Pożar budynku");
        myNominalValues.add("Pożar traw");
        myNominalValues.add("Pożar lasu");
        myNominalValues.add("Zdarzenie drogowe");
        myNominalValues.add("Gwałtowne opady atmosferyczne");
        myNominalValues.add("Plamy substancji ropopochodnych");
        myNominalValues.add("Huragany, silne wiatry");
        myNominalValues.add("Pozostałe");

        attributes.add(new Attribute("Zdarzenie", myNominalValues));
        System.out.println("Attr type: " + attributes.get(4).type());

        dataSet = new Instances("Analiza szegółowych typów zdarzeń i sprzętu", attributes, 0);
        dataSet.setClassIndex(dataSet.numAttributes() - 1);

        int numAttributes = dataSet.numAttributes();

        for (IncidentFull incidentFull : incidents) {
            String incidentSubType = incidentFull.getIncident().getSubtype();

            if (incidentSubType.length() > 0) {

                Instance instance = new DenseInstance(numAttributes);

                for (int i = 0; i < numAttributes - 1; i++) {
                    String attributeName = dataSet.attribute(i).name();
                    for (CarIncident carIncident : incidentFull.getCars()) {
                        for (Equipment equipment : carIncident.getUsedEquipments()) {
                            if (equipment.getSubtype().equals(attributeName))
                                instance.setValue(attributes.get(i), "true");
                        }
                    }
                }
                instance.setValue(attributes.get(numAttributes - 1), incidentSubType);
                dataSet.add(instance);
            }
        }

        Apriori apriori = new Apriori();
        try {
            apriori.buildAssociations(dataSet);
        } catch (Exception e) {
            e.printStackTrace();
        }

        List<String> result = new ArrayList<String>();

        if (!simpleReport) {
            result.add(dataSet.toSummaryString());
            result.add(apriori.toString());
        } else {
            result.add(buildSimpleDataInfo(dataSet));
            result.add(buildSimpleReport(apriori));
        }


        return result;
    }

    private static String buildSimpleDataInfo(Instances dataSet) {
        StringBuilder sb = new StringBuilder();
        sb.append("Reguły zostały wygenerowane na podstawie następujących danych:\n");
        sb.append("Nazwa relacji: " + dataSet.relationName() + "\n");
        sb.append("Liczba zdarzeń zebranych do analizy: " + dataSet.numInstances() + "\n");
        sb.append("Liczba atrybutów branych pod uwagę przy analizie: " + dataSet.numAttributes() + "\n");
        sb.append("\nLista atrybutów: \n");
        for (int i = 0; i < dataSet.numAttributes(); i++) {
            sb.append(i + 1 + ". ");
            sb.append(dataSet.attribute(i).name());
            sb.append("\n");
        }

        return sb.toString();
    }

    private static String buildSimpleReport(Apriori apriori) {
        StringBuilder sb = new StringBuilder();
        AssociationRules associationRules = apriori.getAssociationRules();
        List<AssociationRule> rulesList = associationRules.getRules();
        for (int i = 0; i < rulesList.size(); i++) {
            AssociationRule rule = rulesList.get(i);
            List<Item> premises = (List<Item>) rule.getPremise();
            List<Item> consequence = (List<Item>) rule.getConsequence();
            sb.append(i + 1 + ". Jeśli ");
            for (Item item : premises) {
                sb.append(item.getAttribute().name() + ": " + translateItemValue(item.getItemValueAsString()) + ", ");
            }
            sb.append(" wtedy ");
            for (Item item : consequence) {
                sb.append(item.getAttribute().name() + ": " + translateItemValue(item.getItemValueAsString()) + ", ");
            }
            sb.append("\n");
        }


        return sb.toString();
    }

    private static String translateItemValue(String itemValue) {
        String translation = null;
        switch (itemValue) {
            case "true":
                translation = "użyty";
                break;
            case "false":
                translation = "nieużyty";
                break;
            default:
                translation = itemValue;
        }
        return translation;
    }


}
