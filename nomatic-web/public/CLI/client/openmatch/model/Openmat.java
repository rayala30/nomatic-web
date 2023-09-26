package com.rayala30.nomatic.client.openmatch.model;

import java.time.LocalDate;
import java.time.LocalTime;


public class Openmat {
    // Instance variables
    private boolean isPublic;
    private int openmatId;
    private String name;
    private String locationName;
    private String streetAddress1;
    private String streetAddress2;
    private String city;
    private String state;
    private String zipCode;

    private LocalDate startDate;
    private LocalTime startTime;
    private int duration;
    private int eventHostId;



    // Getters


    public boolean isPublic() {
        return isPublic;
    }

    public int getOpenmatId() {
        return openmatId;
    }

    public String getName() {
        return name;
    }


    public String getLocationName() {
        return locationName;
    }

    public String getStreetAddress1() {
        return streetAddress1;
    }

    public String getStreetAddress2() {
        return streetAddress2;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public int getDuration() {
        return duration;
    }

    public int getEventHostId() {
        return eventHostId;
    }



    // Setters


    public void setPublic(boolean aPublic) {
        isPublic = aPublic;
    }

    public void setOpenmatId(int openmatId) {
        this.openmatId = openmatId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public void setStreetAddress1(String streetAddress1) {
        this.streetAddress1 = streetAddress1;
    }

    public void setStreetAddress2(String streetAddress2) {
        this.streetAddress2 = streetAddress2;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setEventHostId(int eventHostId) {
        this.eventHostId = eventHostId;
    }


    // Constructors

    public Openmat(boolean isPublic, int openmatId, int eventHostId, String name, String locationName, String streetAddress1, String streetAddress2, String city, String state, String zipCode, LocalDate eventDate, LocalTime startTime, int duration) {
        this.isPublic = isPublic;
        this.openmatId = openmatId;
        this.eventHostId = eventHostId;
        this.name = name;
        this.locationName = locationName;
        this.streetAddress1 = streetAddress1;
        this.streetAddress2 = streetAddress2;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.startDate = eventDate;
        this.startTime = startTime;
        this.duration = duration;
    }

    public Openmat() {
    }

    // Methods

}
