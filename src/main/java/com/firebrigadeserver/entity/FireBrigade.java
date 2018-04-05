package com.firebrigadeserver.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "fire_brigade")
public class FireBrigade implements Serializable, IFireBrigade {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_fire_brigade", unique = true, nullable = false)
    private int idFireBrigade;

    @Column(name = "name")
    private String name;

    @Column(name = "voivodeship")
    private String voivodeship;

    @Column(name = "district")
    private String district;

    @Column(name = "community")
    private String community;

    @Column(name = "city")
    private String city;

    @Column(name = "is_in_ksrg")
    private int ksrg;

    @OneToOne
    @JoinColumn(name = "id_user")
    private User user;

    @OneToMany(mappedBy = "fireBrigade")
    @JsonManagedReference
    private List<Firefighter> firefighters;

    @OneToMany(mappedBy = "fireBrigade")
    @JsonManagedReference
    private List<Car> cars;

    @OneToMany(mappedBy = "fireBrigade")
    @JsonManagedReference
    private List<Equipment> fireBrigadeEquipment;

    @OneToMany(mappedBy = "fireBrigade")
    @JsonBackReference
    private List<FirebrigadeIncident> incidents;

    public FireBrigade() {
        this(-1, null, null, null, null, null, -1);
    }

    public FireBrigade(int id, String name) {
        this(id, name, null, null, null, null, -1);
    }

    public FireBrigade(int id, String name, String voivodeship, String district, String community, String city, int ksrg) {
        this.idFireBrigade = id;
        this.name = name;
        this.voivodeship = voivodeship;
        this.district = district;
        this.community = community;
        this.city = city;
        this.ksrg = ksrg;
    }


    public int getIdFireBrigade() {
        return idFireBrigade;
    }

    public void setIdFireBrigade(int idFireBrigade) {
        this.idFireBrigade = idFireBrigade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVoivodeship() {
        return voivodeship;
    }

    public void setVoivodeship(String voivodeship) {
        this.voivodeship = voivodeship;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCommunity() {
        return community;
    }

    public void setCommunity(String community) {
        this.community = community;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int isKsrg() {
        return ksrg;
    }

    public void setKsrg(int ksrg) {
        this.ksrg = ksrg;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public List<Firefighter> getFirefighters() {
        return firefighters;
    }

    public void setFirefighters(List<Firefighter> firefighters) {
        this.firefighters = firefighters;
    }


    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Equipment> getFireBrigadeEquipment() {
        return fireBrigadeEquipment;
    }

    public void setFireBrigadeEquipment(List<Equipment> fireBrigadeEquipment) {
        this.fireBrigadeEquipment = fireBrigadeEquipment;
    }

    public List<FirebrigadeIncident> getIncidents() {
        return incidents;
    }

    public void setIncidents(List<FirebrigadeIncident> incidents) {
        this.incidents = incidents;
    }

    @Override
    public String toString() {
        return "FireBrigade{" +
                "idFireBrigade=" + idFireBrigade +
                ", name='" + name + '\n' +
                ", voivodeship='" + voivodeship + '\n' +
                ", district='" + district + '\n' +
                ", community='" + community + '\n' +
                ", city='" + city + '\n' +
                ", ksrg=" + ksrg + '\n' +
                ", user=" + user.toString() +
                ", firefighters=" + firefighters + '\n' +
                ", cars=" + cars + '\n' +
                ", fireBrigadeEquipment=" + fireBrigadeEquipment + '\n' +
                ", incidents=" + incidents + '\n' +
                '}';
    }
}
