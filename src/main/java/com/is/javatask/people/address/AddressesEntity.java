package com.is.javatask.people.address;

import com.is.javatask.people.model.PeopleEntity;
import jakarta.persistence.*;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "t_addresses")
@SecondaryTable(name = "t_people")
public class AddressesEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "t_people_id", nullable = false)
    private PeopleEntity people;
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

    public PeopleEntity getPeople() {
        return people;
    }

    public void setPeople(PeopleEntity people) {
        this.people = people;
    }

    @Override
    public String toString() {
        return "AddressesEntity{" +
                "id=" + id +
                ", addrType='" + addrType + '\'' +
                ", addrInfo='" + addrInfo + '\'' +
                '}';
    }
}
