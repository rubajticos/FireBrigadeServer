package com.firebrigadeserver.dto;

public class EquipmentDTO {

    private int id;
    private String name;
    private String type;
    private String subtype;
    private FireBrigadeDTO fireBrigade;

    public EquipmentDTO() {
    }

    public EquipmentDTO(int id, String name, String type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSubtype() {
        return subtype;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }

    public FireBrigadeDTO getFireBrigade() {
        return fireBrigade;
    }

    public void setFireBrigade(FireBrigadeDTO fireBrigade) {
        this.fireBrigade = fireBrigade;
    }
}
