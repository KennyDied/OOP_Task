package ru.vsu.cs.oop2020.danila.objects;

import java.util.*;

public class Group {
    private static int numOfGroup;
    private int idOfGroup;
    private ArrayList<Student> listOfStudents;
    private LinkedList<Discipline> disciplinesInGroup;

    public Group(ArrayList<Student> listOfStudents, LinkedList<Discipline> disciplinesInGroup) {
        numOfGroup ++;
        idOfGroup = numOfGroup;
        this.listOfStudents = listOfStudents;
        this.disciplinesInGroup = disciplinesInGroup;
    }

    public int getIdOfGroup() { return idOfGroup; }

    public void printStudentsInGroup(){
        for (Student stds:listOfStudents) {
            System.out.print(stds.getName() + " ");
        }
    }

    public Discipline getDiscipline(int index){
        return disciplinesInGroup.get(index);
    }

    public void removeDiscipline(Discipline d){
        disciplinesInGroup.remove(d);
    }

    public boolean containsDiscipline(Discipline d){
        for (Discipline dis:disciplinesInGroup) {
            if (dis.equals(d)){
                return true;
            }
        }
        return false;
    }
}