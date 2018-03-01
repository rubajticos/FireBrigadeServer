package com.firebrigadeserver.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "fire_brigade")
public class FireBrigade {

    private int idFireBrigade;
    private String name;
    private String voivodeship;
    private String district;
    private String community;
    private String city;
    private int ksrg;
    private User user;
    private Set<Firefighter> firefighters;

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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_fire_brigade", unique = true, nullable = false)
    public int getIdFireBrigade() {
        return idFireBrigade;
    }

    public void setIdFireBrigade(int idFireBrigade) {
        this.idFireBrigade = idFireBrigade;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "voivodeship")
    public String getVoivodeship() {
        return voivodeship;
    }

    public void setVoivodeship(String voivodeship) {
        this.voivodeship = voivodeship;
    }

    @Column(name = "district")
    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    @Column(name = "community")
    public String getCommunity() {
        return community;
    }

    public void setCommunity(String community) {
        this.community = community;
    }

    @Column(name = "city")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Column(name = "is_in_ksrg")
    public int isKsrg() {
        return ksrg;
    }

    public void setKsrg(int ksrg) {
        this.ksrg = ksrg;
    }

    @OneToOne
    @JoinColumn(name = "id_user")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @OneToMany(mappedBy = "fireBrigade")
    public Set<Firefighter> getFirefighters() {
        return firefighters;
    }

    public void setFirefighters(Set<Firefighter> firefighters) {
        this.firefighters = firefighters;
    }
}
