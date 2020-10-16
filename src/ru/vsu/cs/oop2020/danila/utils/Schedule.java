package ru.vsu.cs.oop2020.danila.utils;

import ru.vsu.cs.oop2020.danila.objects.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Schedule {
    private ArrayList<Group> groups;
    private  ArrayList<Discipline> subjects;
    private ArrayList<Lector> lecturers;
    private List<Day[]> sch;

    public Schedule(){
        this.groups = new ArrayList<>();
        this.subjects = new ArrayList<>();
        this.lecturers = new ArrayList<>();
        this.sch = new ArrayList<>();
    }

    public void createStudentsAndGroup(){
        System.out.println("Создаю студентов и группы...");
        Generator gnr = new Generator();

        for (int i = 0; i < 4; i++) {
            ArrayList<Student> students = new ArrayList<>();
            for (int j = 0; j < 20; j++) {
                students.add(new Student(gnr.createName(), i*20 + j));
            }

            LinkedList<Discipline> disciplinesInGroup = new LinkedList<>();
            for (Discipline subject : subjects) {
                disciplinesInGroup.add(subject);
                disciplinesInGroup.add(subject);
            }
            groups.add(new Group(students, disciplinesInGroup));
        }
    }

    public void createSubjects(){
        System.out.println("Создаю предметы...");
        subjects.add(new Discipline("ТФКП"));
        subjects.add(new Discipline("Дифференциальные уравнения"));
        subjects.add(new Discipline("Дискретная математика"));
        subjects.add(new Discipline("Управление данными"));
        subjects.add(new Discipline("ООП"));
        subjects.add(new Discipline("Психология"));
        subjects.add(new Discipline("Алгебра и геометрия"));
        subjects.add(new Discipline("Теория вероятностей"));
        subjects.add(new Discipline("Математический анализ"));
        subjects.add(new Discipline("АИСД"));
        subjects.add(new Discipline("Экономика"));
        subjects.add(new Discipline("История"));
    }

    public void createLectors(){
        Generator gnr = new Generator();
        System.out.println("Созадаю лекторов...");
        for (int i = 0; i < subjects.size() - 1; i++) {
            Lector lec;
            do {
                lec = new Lector(gnr.createName());
            } while (lecturers.contains(lec));
            lecturers.add(lec);
        }
    }

    public void connectLectorsAndDisciplines(){
        System.out.println("Сопоставляю лекторов с дисциплинами...");
        int k = 1;
        for (Lector l:lecturers) {
            l.addDiscipline(subjects.get(k - 1));
            l.addDiscipline(subjects.get(k));
            k++;
        }
    }

    public Day[] createDay() throws NullPointerException{
        Day[] dayForGroup = new Day[4];
        for (int i = 0; i < 4; i++) {       //4 группы
            Day day = new Day();
            for (int j = 0; j < 5; j++) {  //5 пар
                Lector l;
                Discipline d;
                do {
                    l = lecturers.get(Generator.rndNumberInRange(0, lecturers.size()));     //рандомный лектор
                    d = l.getDisciplines().get(Generator.rndNumberInRange(0, 1));           //рандомная дисциплина у лектора
                } while (l.hasPair(dayForGroup, i, j) && groups.get(i).containsDiscipline(d));  //у лектора в этот день нет пары и у группы не было этого предмета

                if (l.hasPair(dayForGroup, i, j)){  //окно
                    day.addPair(null);
                } else {
                    groups.get(i).removeDiscipline(d);
                    day.addPair(new Pair(d, l, groups.get(i)));
                }
            }
            dayForGroup[i] = day;   //массив из дней для каждой группы в определенный день недели
        }
        return dayForGroup;
    }

    public void createSchedule(){
        createSubjects();
        createLectors();
        createStudentsAndGroup();
        connectLectorsAndDisciplines();

        for (int i = 0; i < 6; i++) {
            sch.add(createDay());
        }
    }
    public List<Day[]> getDays(){
        return sch;
    }
}