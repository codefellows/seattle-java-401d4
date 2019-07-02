package com.ferreirae.code401d4.day12.firstWebApp;

import javax.persistence.*;
import java.util.List;

@Entity
public class Language {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String nameInEnglish;
    String nameInItself;

    // mappedBy String comes from name of instance var in Greeting.java
    @OneToMany(mappedBy = "language")
    List<Greeting> greetings;

    public Language() {}

    public Language(String nameInEnglish) {
        this.nameInEnglish = nameInEnglish;
        this.nameInItself = null;
    }

    public int getId() {
        return id;
    }

    public String getNameInEnglish() {
        return nameInEnglish;
    }

    public String getNameInItself() {
        return nameInItself;
    }

    public List<Greeting> getGreetings() {
        return greetings;
    }
}
