package com.digitalharbor.hospital.model;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "PATIENT")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    Long id;
    @Column(name="NAME")
    String name;
    @Column(name="PHONE")
    String phone;
    @Column(name="CITY")
    String city;
    @Column(name="ADDRESS")
    String address;
    @Column(name="created")
    String created;
    @Column(name="createdBy")
    String createdBy;
    @Column(name="updated")
    String updated;
    @Column(name="updatedBy")
    String updatedBy;

    @ManyToOne( optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "HOSPITAL_ID",nullable = false)
    Hospital hospital;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    private Set<Notes> notes;

    //GETTERS & SETTERS
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
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    public Set<Notes> getNotes() {
        return notes;
    }

    public void setNotes(Set<Notes> notes) {
        this.notes = notes;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }
}
