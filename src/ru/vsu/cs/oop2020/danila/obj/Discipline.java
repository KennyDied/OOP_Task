package ru.vsu.cs.oop2020.danila.obj;

public class Discipline {
    private static int numOfDisciplines = 0;

    private String nameOfDiscipline;

    public Discipline(String nameOfDiscipline) {

        this.nameOfDiscipline = nameOfDiscipline;
        numOfDisciplines++;
    }

    public static int getNumOfDisciplines() {
        return numOfDisciplines;
    }

    public String getNameOfDiscipline() {
        return nameOfDiscipline;
    }
}
