package com.is.javatask.people.model;

import jakarta.persistence.*;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "t_addresses")
public class AddressesEntity{
    @Id
    @Column
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;
    @Column(name = "t_people_id")
    private Integer peopleId;
    @Column
    private String addrType;
    @Column
    private String addrInfo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPeopleId() {
        return peopleId;
    }

    public void setPeopleId(Integer peopleId) {
        this.peopleId = peopleId;
    }

    public String getAddrType() {
        return addrType;
    }

    public void setAddrType(String addrType) {
        this.addrType = addrType;
    }

    public String getAddrInfo() {
        return addrInfo;
    }

    public void setAddrInfo(String addrInfo) {
        this.addrInfo = addrInfo;
    }

    @Override
    public String toString() {
        return "AddressesEntity{" +
                "id=" + id +
                ", peopleId=" + peopleId +
                ", addrType='" + addrType + '\'' +
                ", addrInfo='" + addrInfo + '\'' +
                '}';
    }
}
