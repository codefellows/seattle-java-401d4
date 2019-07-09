package com.company;

import static java.lang.System.out;

public class Main {

    public static void main(String[] args) {

        HashTable ht = new HashTable(16);
        ht.set("John", "Husband");
        ht.set("Cathy", "Boss");
        ht.set("Amanda", "The Real Boss");
        ht.set("Allie", "Kid");
        ht.set("Zach", "Kid");
        ht.set("Rosie", "Dog");
        ht.set("Justin", "Student");
        ht.set("Demi", "Dog");
        ht.set("Ovi", "Student");
        ht.set("Ben", "Student");
        ht.set("Khalil", "Student");
        ht.set("Michael", "Student");
        ht.set("Timea", "Student");
        ht.set("Jason", "Student");
        System.out.println("done");
    }

}
