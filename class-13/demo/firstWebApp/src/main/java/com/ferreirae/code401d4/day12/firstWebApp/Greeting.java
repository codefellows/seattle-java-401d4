package com.ferreirae.code401d4.day12.firstWebApp;

import javax.persistence.*;

// hello, in English
// hola, in Spanish
// good day, in English

// Greeting model
@Entity
public class Greeting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    // name of this variable matches mappedBy in Language.java
    @ManyToOne
    Language language;
    String text;

    public Greeting() {}
    public Greeting(String text, Language language) {
        this.language = language;
        this.text = text;
    }

    public String getText() {
        return this.text;
    }

    public Language getLanguage() {
        return this.language;
    }
}
