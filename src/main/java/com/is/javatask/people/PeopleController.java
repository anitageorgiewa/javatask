package com.is.javatask.people;

import com.is.javatask.people.dto.FullInfoDto;
import com.is.javatask.people.dto.PeopleDto;
import com.is.javatask.people.dto.Search;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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
    public String create(@Valid PeopleDto peopleDto, BindingResult bindingResult){
         if (bindingResult.hasErrors()) {
            return "create";
         }
         peopleService.create(peopleDto);
         return "redirectAfterCreate";
    }

    @GetMapping("/people/create")
    public String create(Model model){
        model.addAttribute("peopleDto",new PeopleDto());
        return "create";
    }

    @GetMapping("/people/info/{id}")
    public String searchMoreInfo(Model model, @PathVariable String id) {
        model.addAttribute("id",id);
        return "contacts";
    }

    @PostMapping("/people/info")
    public String searchSubmitMoreInfo(@ModelAttribute PeopleDto peopleDto, Model model) {
        FullInfoDto fullInfoDto = new FullInfoDto();
        fullInfoDto.setPeopleId(peopleDto.getId());
        fullInfoDto.setFullName(peopleDto.getFullName());
      //  List<FullInfoDto> info = peopleService.fullSearch();
        //model.addAttribute("peopleResults", peopleDtos);
        return "people";
    }

}
