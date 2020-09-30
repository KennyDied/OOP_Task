package ru.vsu.cs.oop2020.danila;

import java.util.Set;

public class Lector {
    private String name;
    private String surname;
    private Set<TaughtSubject> ListOfTaughtSubjects;

    public Lector(String name, String surname, Set<TaughtSubject> listOfTaughtSubjects) {
        this.name = name;
        this.surname = surname;
        this.ListOfTaughtSubjects = listOfTaughtSubjects;
    }
}