package ru.vsu.cs.oop2020.danila;

import java.util.Set;

public class Group {
    private int numOfGroup;
    private Set<Student> ListOfStudents;


    public Group(int numOfGroup, Set<Student> listOfStudents) {
        this.numOfGroup = numOfGroup;
        this.ListOfStudents = listOfStudents;
    }
}