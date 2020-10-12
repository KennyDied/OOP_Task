package ru.vsu.cs.oop2020.danila.obj;

import ru.vsu.cs.oop2020.danila.Pair;

import java.util.ArrayList;

public class Lector {
    private String name;
    private ArrayList<Discipline> disciplines;

    public Lector(String name) {
        this.name = name;
        this.disciplines = new ArrayList<>();
    }

    public void addDiscipline(Discipline dis){
        disciplines.add(dis);
    }

    public int numOfDisciplines(){
        return disciplines.size();
    }

    public void printAllDiscipline(){
        System.out.print(name + " - ");
        for (Discipline d:disciplines) {
            System.out.print(d.getNameOfDiscipline() + " | ");
        }
        System.out.println();
    }

    public String getName() {
        return name;
    }
}