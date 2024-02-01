package com.is.javatask.people;

import com.is.javatask.people.mail.MailsDto;
import com.is.javatask.people.model.PeopleEntity;
import com.is.javatask.people.model.dto.PeopleDto;
import com.is.javatask.people.model.dto.Search;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
public class PeopleController {

    private PeopleService peopleService;

    public PeopleController(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    @GetMapping("/people")
    public String searchForm(Model model) {
        model.addAttribute("search", new Search());
        return "people";
    }

    @PostMapping("/people")
    public String searchSubmit(@ModelAttribute Search search, Model model) {
        List<PeopleDto> peopleDtos = peopleService.searchPeople(search.getTerm());
        model.addAttribute("peopleResults", peopleDtos);
        return "result";
    }

    @GetMapping("/people/contacts")
    public String showContacts(@RequestParam("id") Integer peopleId, Model model) {
        var contacts = peopleService.getContacts(peopleId);
        model.addAttribute("contacts", contacts);
        return "contacts";
    }

    @GetMapping("/people/create")
    public String create(Model model) {
        model.addAttribute("peopleDto", new PeopleDto());
        return "create";
    }

    @PostMapping("/people/create")
    public String create(@Valid PeopleDto peopleDto, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "create";
        }
        PeopleEntity people = peopleService.create(peopleDto);
        MailsDto mailsDto = new MailsDto();
        mailsDto.setPeopleId(people.getId());
        model.addAttribute("mailsDto", mailsDto);
        return "createMail";
    }
}
