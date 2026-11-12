package com.transport.transportCompany.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.Table;

@Entity
@Table(name = "bus")
public class Bus{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String company;

    @Column(name = "license_plate")
    private String licensePlate;

    @Column(name = "num_seats")
    private Integer numSeats;

    private Integer hp;

    @Column(name = "power_supply")
    private String powerSupply;

    
    public Bus() {}  //costruttore di default, necessario


    public Bus(Long aId, String aCompany, String aLicensePlate, Integer aNumSeats, Integer aHp, String aPowerSupply){
        id = aId;
        company = aCompany;
        licensePlate = aLicensePlate;
        numSeats = aNumSeats;
        hp = aHp;
        powerSupply = aPowerSupply;
    }


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getCompany() {
        return company;
    }


    public void setCompany(String company) {
        this.company = company;
    }


    public Integer getHp() {
        return hp;
    }


    public void setHp(Integer hp) {
        this.hp = hp;
    }


    public Integer getNumSeats() {
        return numSeats;
    }


    public void setNumSeats(Integer numSeats) {
        this.numSeats = numSeats;
    }


    public String getPowerSupply() {
        return powerSupply;
    }


    public void setPowerSupply(String powerSupply) {
        this.powerSupply = powerSupply;
    }


    public String getLicensePlate() {
        return licensePlate;
    }


    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

}