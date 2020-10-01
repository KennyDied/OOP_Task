package ru.vsu.cs.oop2020.danila;

import java.util.Set;

public class Lector {
    private String name;
    private String surname;
    private Set<Pair> listOfPairs;

    public Lector(String name, String surname, Set<Pair> listOfPairs) {
        this.name = name;
        this.surname = surname;
        this.listOfPairs = listOfPairs;
    }
}