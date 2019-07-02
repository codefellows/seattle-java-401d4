package com.ferreirae.code401d4.day12.firstWebApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class GreetingController {

    @Autowired
    GreetingRepository greetingRepository;
    @Autowired
    LanguageRepository languageRepository;

    @GetMapping("/greetings")
    public String getAllGreetings(Model m) {
        Iterable<Greeting> greetings = greetingRepository.findAll();
        m.addAttribute("greetings", greetings);
        return "allGreetings";
    }

    @GetMapping("/greetings/new")
    public String getAddGreetingForm() {
        return "greetingForm";
    }

    @GetMapping("/languages/{id}/randomGreeting")
    public String getRandomGreeting(@PathVariable int id, Model m) {
        // .get to get value inside of optional
        Language l = languageRepository.findById(id).get();
        int size = l.getGreetings().size();
        Greeting randomGreeting = l.getGreetings().get((int)(Math.random() * size));
        m.addAttribute("greeting", randomGreeting);
        return "randomGreeting";
    }

    @PostMapping("/greetings")
    public RedirectView addGreeting(@RequestParam String text, @RequestParam String language) {
        List<Language> languagesWithThatName = languageRepository.findByNameInEnglish(language);
        if(languagesWithThatName.size() > 0) {
            //                                     languagesWithThatName[0]
            Greeting greeting = new Greeting(text, languagesWithThatName.get(0));
            greetingRepository.save(greeting);
            return new RedirectView("/greetings");
        } else {
            Greeting greeting = new Greeting(text, new Language(language));
            greetingRepository.save(greeting);
            return new RedirectView("/greetings");
        }

    }
}
