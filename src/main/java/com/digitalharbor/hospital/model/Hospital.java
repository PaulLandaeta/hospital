package com.digitalharbor.hospital.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Hospital")
public class Hospital {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    Long id;
    @Column(name="NAME")
    String name;
    @Column(name="ADDRESS")
    String address;
    @Column(name="PHOTO_URL")
    String photoURL;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhotoURL() {
        return photoURL;
    }

    public void setPhotoURL(String photoURL) {
        this.photoURL = photoURL;
    }

}
