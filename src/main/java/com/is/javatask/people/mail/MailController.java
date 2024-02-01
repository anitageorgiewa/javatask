package com.is.javatask.people.mail;

import com.is.javatask.people.address.AddressesDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MailController {

    private MailService mailService;

    @Autowired
    public MailController(MailService mailService) {
        this.mailService = mailService;
    }

    @PostMapping("/people/create/mail")
    public String createAddress(@Valid MailsDto mailsDto, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "createMail";
        }
        mailsDto.setPeopleId(mailsDto.getPeopleId());
        Integer peopleId = mailService.createMail(mailsDto);
        AddressesDto addressesDto = new AddressesDto();
        addressesDto.setPeopleId(peopleId);
        model.addAttribute("addressesDto", addressesDto);

        return "createAddress";
    }

    @PostMapping("/people/edit/mail")
    public String saveEditMail(@Valid MailsDto mails, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "editMail";
        }
        mailService.editMail(mails);
        return "redirectAfterUpdate";
    }

    @GetMapping("/people/edit/mail")
    public String getInfoForUpdateMail(@RequestParam("id") Integer id, Model model) {
        model.addAttribute("mails", mailService.getMails(id));
        return "editMail";
    }

    @GetMapping("/people/delete/mail")
    public String deleteMail(@RequestParam Integer id, Model model) {
        model.addAttribute("id", id);
        return "deleteMessageMail.html";
    }

    @GetMapping("/people/delete/m")
    public String deleteMailOK(@RequestParam Integer id) {
        Integer peopleId = mailService.deleteMail(id);
        return "redirect:/people/contacts?id=" + peopleId;
    }

}
