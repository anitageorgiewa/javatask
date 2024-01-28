package com.is.javatask.people.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "t_addresses")
public class AddressesEntity{
    @Id
    @Column
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;
    @Column(name = "t_people_id")
    @NotNull
    private Integer peopleId;
    @Column
    @Length(max = 5)
    private String addrType;
    @Column
    @Length(max = 10)
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
