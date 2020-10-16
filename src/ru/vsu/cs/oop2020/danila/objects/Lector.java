package ru.vsu.cs.oop2020.danila.objects;

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

    public ArrayList<Discipline> getDisciplines() {
        return disciplines;
    }

    public boolean hasPair(Day[] day, int group, int hour) throws NullPointerException{
        for (int i = group - 1; i >= 0; i--) {
            try {
                if (day[i].getPairByHour(hour).getLector().getName().equals(name)){
                    return true;
                }
            } catch (Exception e) {
                return false;
            }
        }
        return false;
    }
}