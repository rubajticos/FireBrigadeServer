package com.firebrigadeserver.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "equipment")
public class Equipment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_equipment")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private String type;

    @ManyToOne
    @JoinColumn(name = "id_firebrigade")
    private FireBrigade fireBrigade;

    @OneToMany(mappedBy = "equipment")
    private List<CarEquipment> equipmentOnTheCar;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "usedEquipments")
    private List<CarIncident> carIncidents;


    public Equipment() {
        this(-1, null, null);
    }

    public Equipment(int id, String name) {
        this(id, name, null);
    }

    public Equipment(int id, String name, String type) {
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

    public FireBrigade getFireBrigade() {
        return fireBrigade;
    }

    public void setFireBrigade(FireBrigade fireBrigade) {
        this.fireBrigade = fireBrigade;
    }

    public List<CarEquipment> getEquipmentOnTheCar() {
        return equipmentOnTheCar;
    }

    public void setEquipmentOnTheCar(List<CarEquipment> equipmentOnTheCar) {
        this.equipmentOnTheCar = equipmentOnTheCar;
    }

    public List<CarIncident> getCarIncidents() {
        return carIncidents;
    }

    public void setCarIncidents(List<CarIncident> carIncidents) {
        this.carIncidents = carIncidents;
    }
}
