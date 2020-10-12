package ru.vsu.cs.oop2020.danila;

import ru.vsu.cs.oop2020.danila.obj.Discipline;
import ru.vsu.cs.oop2020.danila.obj.Group;
import ru.vsu.cs.oop2020.danila.obj.Lector;
import ru.vsu.cs.oop2020.danila.obj.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Generator gnr = new Generator();
        System.out.println("Create students and group...");

        ArrayList<Group> gr = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            ArrayList<Student> students = new ArrayList<>();
            for (int j = 0; j < 20; j++) {
                students.add(new Student(gnr.createName(), i*20 + j));
            }
            gr.add(new Group(students));
        }


        System.out.println("Create subjects...");
        ArrayList<Discipline> subjects = new ArrayList<>();
        subjects.add(new Discipline("ТФКП"));
        subjects.add(new Discipline("Дифференциальные уравнения"));
        subjects.add(new Discipline("Дискретная математика"));
        subjects.add(new Discipline("Управление данными"));
        subjects.add(new Discipline("ООП"));
        subjects.add(new Discipline("Психология"));

        System.out.println("Create lecturers...");
        ArrayList<Lector> lecturers = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            lecturers.add(new Lector(gnr.createName()));
            for (int j = 0; j < 2; j++) {
                lecturers.get(i).addDiscipline(subjects.get(Math.abs(5 * j - i)));
            }
            //lecturers.get(i).printAllDiscipline();
        }

        System.out.println("Create schedule...");

        Day[][] monday = new Day[5][4];
        monday[0][gr.get(0).getIdOfGroup()] = new Pair(subjects.get(0), lecturers.get(0), gr.get(0));
        monday.addPair(new Pair(subjects.get(1), lecturers.get(1), gr.get(1)));
        monday.printPairs();


    }
}