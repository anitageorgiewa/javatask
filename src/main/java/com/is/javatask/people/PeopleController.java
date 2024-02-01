package com.is.javatask.people;

import com.is.javatask.people.dto.*;
import com.is.javatask.people.model.PeopleEntity;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class PeopleController {

    private static Logger logger = LoggerFactory.getLogger(PeopleController.class);

    private PeopleService peopleService;

    public PeopleController(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    @GetMapping("/people")
    public String searchForm(Model model) {
        model.addAttribute("search",new Search());
        return "people";
    }

    @PostMapping("/people")
    public String searchSubmit(@ModelAttribute Search search, Model model) {
        logger.debug("search:", search);
        List<PeopleDto> peopleDtos = peopleService.searchPeople(search.getTerm());
        model.addAttribute("peopleResults", peopleDtos);
        return "result";
    }

    @PostMapping("/people/create")
    public String create(@Valid PeopleDto peopleDto, BindingResult bindingResult, Model model){
         if (bindingResult.hasErrors()) {
            return "create";
         }
        PeopleEntity people = peopleService.create(peopleDto);
        MailsDto mailsDto = new MailsDto();
        mailsDto.setPeopleId(people.getId());
        model.addAttribute("mailsDto",mailsDto);
        return "createMail";
    }

    @GetMapping("/people/create")
    public String create(Model model){
        model.addAttribute("peopleDto",new PeopleDto());
        return "create";
    }

    @GetMapping("/people/contacts")
    public String showContacts(@RequestParam("id") Integer peopleId, Model model) {
        var contacts = peopleService.getContacts(peopleId);
        model.addAttribute("contacts", contacts);
        return "contacts";
    }

    @PostMapping("/people/create/mail")
    public String createMail(@Valid MailsDto mailsDto, BindingResult bindingResult, Model model){

        if (bindingResult.hasErrors()) {
            return "createMail";
        }
        mailsDto.setPeopleId(mailsDto.getPeopleId());
        peopleService.createMail(mailsDto);
        AddressesDto addressesDto = new AddressesDto();
        addressesDto.setPeopleId(mailsDto.getPeopleId());
        model.addAttribute("addressesDto",addressesDto);
        return "createAddress";
    }
    @PostMapping("/people/create/address")
    public String createAddress(@Valid AddressesDto addressesDto, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return "createAddress";
        }
        addressesDto.setPeopleId(addressesDto.getPeopleId());
        peopleService.createAddress(addressesDto);
        return "redirectForMoreInfo";
    }

    @GetMapping("/people/edit")
    public String getInfoForUpdate(@RequestParam Integer id,Model model){
        FullProfileDto fullProfileDto = peopleService.getProfile(id);
        model.addAttribute("people",fullProfileDto.getPerson());

        model.addAttribute("mails",fullProfileDto.getMails());
        model.addAttribute("addressesForm",new UpdateAddressesForm(fullProfileDto.getAddresses()));
        model.addAttribute("mailsForm",new UpdateMailForm(fullProfileDto.getMails()));
        return "edit";
    }

    @PostMapping("/people/edit/mails")
    public String saveEdit(@Valid @RequestParam UpdateMailForm mails
                           ){


        peopleService.editMail(mails.getMails());
      //  model.addAttribute("contacts",contacts);

        return  "edit";
    }
/*
    @PostMapping("/people/edit")
    public String updatePerson(@Valid @RequestBody FullProfileDto profile, BindingResult bindingResult, Model model,
                               @PathVariable Integer id){
        if (bindingResult.hasErrors()) {
            return "people";
        }
        peopleService.edit(profile);
        model.addAttribute("profile",profile);

        return  "edit";
    }*/
}
