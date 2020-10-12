package ru.vsu.cs.oop2020.danila.obj;

import ru.vsu.cs.oop2020.danila.obj.Group;

public class Student {
    private String name;
    private Group group;
    private int idOfStudent;
    private static int numOfStudent = 0;

    public Student(String name, int idOfStudent) {
        this.name = name;
        this.idOfStudent = idOfStudent;
        numOfStudent++;
    }



    public int getNumOfStudent() {
        return numOfStudent;
    }

    public int getIdOfStudent() {
        return idOfStudent;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Group getGroup() {
        return group;
    }
}
