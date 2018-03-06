package com.firebrigadeserver.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "incident")
public class Incident implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_incident")
    private int id;

    @Column(name = "type")
    private String type;

    @Column(name = "date", columnDefinition = "DATE")
    @Temporal(TemporalType.DATE)
    private Date date;

    @Column(name = "city")
    private String city;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "incident")
    @JsonIgnoreProperties("incident")
    private List<FirebrigadeIncident> fireBrigades;

    @OneToMany(mappedBy = "incident")
    @JsonIgnoreProperties("incident")
    private List<CarIncident> cars;

    public Incident() {
        this(-1, null, null, null, null);
    }

    public Incident(int id, String description, String type, Date date, String city) {
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
