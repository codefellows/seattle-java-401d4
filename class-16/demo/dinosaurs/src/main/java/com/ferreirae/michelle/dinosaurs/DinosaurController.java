package com.ferreirae.michelle.dinosaurs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;
import java.util.List;

@Controller
public class DinosaurController {

    @Autowired
    DinosaurRepository dinoRepository;
    @Autowired
    AppUserRepository appUserRepository;

    @GetMapping("/")
    public String getDinosaurs(Principal p, Model m) {
        System.out.println(p.getName());
        AppUser me = appUserRepository.findByUsername(p.getName());

        m.addAttribute("loggedInUser", me);
        return "dinosaurs";
    }

    @GetMapping("/dinosaurs/add")
    public String getDinosaurCreator() {
        return "createDino";
    }

    @PostMapping("/dinosaurs")
    public RedirectView addDinosaur(String name, String species, boolean isCarnivore, Principal p) {
        Dinosaur newDino = new Dinosaur();
        newDino.name = name;
        newDino.species = species;
        newDino.isCarnivore = isCarnivore;
        AppUser me = appUserRepository.findByUsername(p.getName());
        newDino.creator = me;
        dinoRepository.save(newDino);
        return new RedirectView("/");
    }

    @GetMapping("/dinosaurs/{id}")
    public String showDinosaur(@PathVariable long id, Model m, Principal p) {
        Dinosaur dino = dinoRepository.findById(id).get();
        // check if that dinosaur belongs to the currently logged in user
        if (dino.getCreator().username.equals(p.getName())) {
            // if so, do the nice things
            m.addAttribute("dino", dino);
            m.addAttribute("article",
                    dino.species.matches("[AaEeIiOoUu].*") ? "An" : "A");
            AppUser loggedInUser = appUserRepository.findByUsername(p.getName());
            List<Dinosaur> possibleFriends = loggedInUser.dinosaurs;
            possibleFriends.remove(dino);
            possibleFriends.removeAll(dino.friends);

            m.addAttribute("possibleFriendDinos", possibleFriends);
            return "dinosaur";
        } else {
           // otherwise, tell them no
           throw new DinosaurDoesNotBelongToYouException("That dinosaur does not belong to you.");
        }
    }

    @PostMapping("/dinosaurs/{id}/friends")
    public RedirectView addFriend(@PathVariable Long id, Long friend, Principal p, Model m) {
        // we have the ID of two dinosaurs
        // go get actual Dinosaur instances
        Dinosaur currentDino = dinoRepository.findById(id).get();
        Dinosaur newFriendDino = dinoRepository.findById(friend).get();
        // use the principal: check both of the dinosaurs belong to the currently logged in user
        if(!currentDino.creator.username.equals(p.getName()) || !newFriendDino.creator.username.equals(p.getName())) {
            throw new DinosaurDoesNotBelongToYouException("You must own both dinosaurs to make them be friends.");
        }
        // make them be friends
        currentDino.friends.add(newFriendDino);
        newFriendDino.friends.add(currentDino);
        // save! yes please omg
        dinoRepository.save(currentDino);
        dinoRepository.save(newFriendDino);
        // redirect back to the current dino
        return new RedirectView("/dinosaurs/" + id);
    }
}

// came from https://stackoverflow.com/questions/2066946/trigger-404-in-spring-mvc-controller
@ResponseStatus(value = HttpStatus.FORBIDDEN)
class DinosaurDoesNotBelongToYouException extends RuntimeException {
    public DinosaurDoesNotBelongToYouException(String s) {
        super(s);
    }
}
