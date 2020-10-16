package ru.vsu.cs.oop2020.danila.objects;

public class Pair {
    private Discipline subj;
    private Lector lector;
    private Group group;

    public Pair(Discipline subj, Lector lector, Group group) {
        this.subj = subj;
        this.lector = lector;
        this.group = group;
    }

    public Lector getLector() {
        return lector;
    }

    public void printPair(){
        System.out.println(subj.getNameOfDiscipline() + " - Преподаватель: " + lector.getName() + " | " + group.getIdOfGroup() + " группа");
    }
}