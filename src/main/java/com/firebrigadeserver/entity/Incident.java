package com.firebrigadeserver.entity;

import javax.persistence.*;
import javax.xml.crypto.Data;
import java.util.List;

@Entity
@Table(name = "incident")
public class Incident {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_incident")
    private int id;

    @Column(name = "type")
    private String type;

    @Column(name = "date")
    private Data date;

    @Column(name = "city")
    private String city;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "incident")
    private List<FirebrigadeIncident> fireBrigades;

    @OneToMany(mappedBy = "incident")
    private List<CarIncident> cars;

    public Incident() {
        this(-1, null, null, null, null);
    }

    public Incident(int id, String description, String type, Data date, String city) {
        this.id = id;
        this.description = description;
        this.type = type;
        this.date = date;
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Data getDate() {
        return date;
    }

    public void setDate(Data date) {
        this.date = date;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
