package com.store.GameStep.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "console")
public class Console {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double price;
    private String color;
    private Integer availability;
    private State state;

    public enum State {
        
        /**
        NEW,
        USED,
        AS_NEW
        */

        NEW("N"), USED("U"), AS_NEW("AN");
        
        private String abbreviation;
        private State(String abbreviation){
            this.abbreviation = abbreviation;
        }

        public String getAbbreviation(){return this.abbreviation;}
    }

    public Console() {} //is required

    public Console(Long aId, String aName, Double aPrice, String aColor, Integer aAvailability, State aState){
        id = aId;
        name = aName;
        price = aPrice;
        color = aColor;
        availability = aAvailability;
        state = aState;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getAvailability() {
        return availability;
    }

    public void setAvailability(Integer availability) {
        this.availability = availability;
    }

    public State getState(){
        return state;
    }

    public void setState(State state){
        this.state = state;
    }

    @Override
    public String toString() {
        return "Console [id=" + id + ", name=" + name + ", price=" + price + ", color=" + color + ", availability="
                + availability + ", state=" + state + "]";
    }

}
