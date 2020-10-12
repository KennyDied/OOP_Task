package ru.vsu.cs.oop2020.danila;

import ru.vsu.cs.oop2020.danila.obj.Discipline;
import ru.vsu.cs.oop2020.danila.obj.Group;
import ru.vsu.cs.oop2020.danila.obj.Lector;

public class Pair {

    private Discipline subj;
    private Lector lector;
    private Group group;


    public Pair(Discipline subj, Lector lector, Group group) {
        this.subj = subj;
        this.lector = lector;
        this.group = group;
    }


    public void printPair(){
        System.out.println(subj.getNameOfDiscipline() + " - Преподаватель: " + lector.getName() + " | " + group.getIdOfGroup() + " группа");
    }

}