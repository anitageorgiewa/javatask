package com.is.javatask.people.dto;

import java.util.List;

public class UpdateAddressesForm {

    List<AddressesDto> addresses;

    public UpdateAddressesForm(List<AddressesDto> addresses) {
        this.addresses = addresses;
    }

    public List<AddressesDto> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<AddressesDto> addresses) {
        this.addresses = addresses;
    }
}
