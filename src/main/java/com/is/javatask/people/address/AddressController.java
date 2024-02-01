package com.is.javatask.people.address;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AddressController {

    private AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @PostMapping("/people/create/address")
    public String createAddress(@Valid AddressesDto addressesDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "createAddress";
        }
        addressesDto.setPeopleId(addressesDto.getPeopleId());
        addressService.createAddress(addressesDto);
        return "redirectForMoreInfo";
    }

    @GetMapping("/people/edit/address")
    public String getInfoForUpdateAddress(@RequestParam("id") Integer id, Model model) {
        model.addAttribute("address", addressService.getAddress(id));
        return "editAddress";
    }

    @PostMapping("/people/edit/address")
    public String saveEdit(@Valid AddressesDto address, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "editAddress";
        }
        addressService.editAddress(address);

        return "redirectAfterUpdate";
    }

    @GetMapping("/people/delete/address")
    public String deleteAddress(@RequestParam Integer id, Model model) {
        model.addAttribute("id", id);
        return "deleteMessageAddr";
    }

    @GetMapping("/people/delete/addr")
    public String deleteAddressOK(@RequestParam Integer id) {
        Integer peopleId = addressService.deleteAddress(id);
        return "redirect:/people/contacts?id=" + peopleId;
    }

}
