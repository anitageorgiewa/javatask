package com.is.javatask.people.model.dto;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

public class PeopleDto {

    private Integer id;
    @NotBlank
    @Length(max = 90)
    private String fullName;
    @NotBlank
    @Length(min = 10, max = 10)
    private String pin;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }
}
