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


    @PostMapping("/people/create/address")
    public String createAddress(@Valid AddressesDto addressesDto, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return "createAddress";
        }
        addressesDto.setPeopleId(addressesDto.getPeopleId());
        peopleService.createAddress(addressesDto);
        return "redirectForMoreInfo";
    }

    @GetMapping("/people/edit/mail")
    public String getInfoForUpdateMail(@RequestParam("id") Integer id,Model model){

        model.addAttribute("mails",peopleService.getMails(id));
        return "editMail";
    }

    @PostMapping("/people/edit/mail")
    public String saveEditMail(@Valid MailsDto mails, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return "editMail";
        }
        peopleService.editMail(mails);

        return  "redirect:/people/contacts?id=" + mails.getPeopleId();
    }
    @GetMapping("/people/edit/address")
    public String getInfoForUpdateAddress(@RequestParam("id") Integer id,Model model){

        model.addAttribute("address",peopleService.getAddress(id));
        return "editAddress";
    }

    @PostMapping("/people/edit/address")
    public String saveEdit(@Valid AddressesDto address, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return "editAddress";
        }
        peopleService.editAddress(address);

        return  "redirect:/people/contacts?id=" + address.getPeopleId();
    }


    @GetMapping("/people/delete/address")
    public String deleteAddress(@RequestParam  Integer id){

        Integer peopleId = peopleService.deleteAddress(id);

        return  "redirect:/people/contacts?id=" + peopleId;
    }
    @GetMapping("/people/delete/mail")
    public String deleteMail(@RequestParam  Integer id){

        Integer peopleId =peopleService.deleteMail(id);

        return  "redirect:/people/contacts?id=" + peopleId;
    }
}
