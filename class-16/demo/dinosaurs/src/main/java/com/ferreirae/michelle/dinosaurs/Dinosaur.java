package com.ferreirae.michelle.dinosaurs;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class Dinosaur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    public long getId() {
        return id;
    }

    public AppUser getCreator() {
        return creator;
    }

    public String getName() {
        return name;
    }

    public String getSpecies() {
        return species;
    }

    public boolean getIsCarnivore() {
        return isCarnivore;
    }

    public Set<Dinosaur> getFriends() {
        return this.friends;
    }

    // you might want two variables:
    // a list of followers
    // and a list of followees

    // or maybe just a list of followees
    // you can build it either way
    // don't let me tell you what to do
    @ManyToMany
    Set<Dinosaur> friends;

    @ManyToOne
    AppUser creator;
    String name;
    String species;
    boolean isCarnivore;

}
