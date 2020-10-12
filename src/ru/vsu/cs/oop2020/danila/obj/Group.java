package ru.vsu.cs.oop2020.danila.obj;

import java.util.ArrayList;
import java.util.Set;

public class Group {
    private static int numOfGroup;
    private ArrayList<Student> listOfStudents;
    private int idOfGroup;


    public Group(ArrayList<Student> listOfStudents) {
        this.listOfStudents = listOfStudents;
        numOfGroup ++;
        idOfGroup = numOfGroup;
    }



    public int getNumOfGroup() {
        return numOfGroup;
    }

    public int getIdOfGroup() {
        return idOfGroup;
    }

    public void printStudentsInGroup(){
        for (Student stds:listOfStudents) {
            System.out.print(stds.getName() + " ");
        }
    }
}