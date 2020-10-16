package ru.vsu.cs.oop2020.danila.objects;

public class Discipline {
    private String nameOfDiscipline;

    public Discipline(String nameOfDiscipline) {
        this.nameOfDiscipline = nameOfDiscipline;
    }

    public String getNameOfDiscipline() {
        return nameOfDiscipline;
    }

    @Override
    public boolean equals(Object obj) {
        Discipline discipline = (Discipline) obj;
        return discipline.nameOfDiscipline.equals(nameOfDiscipline);
    }
}