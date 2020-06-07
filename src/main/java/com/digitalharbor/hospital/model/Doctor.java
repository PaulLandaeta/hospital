package com.digitalharbor.hospital.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "DOCTOR")
public class Doctor {
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

    @ManyToOne( optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "HOSPITAL_ID")
    Hospital hospital;

    @ManyToMany
    Set<Speciality> specialities;

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

    public Set<Speciality> getSpecialities() {
        return specialities;
    }

    public void setSpecialities(Set<Speciality> specialities) {
        this.specialities = specialities;
    }
}
