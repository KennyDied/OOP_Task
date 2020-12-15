package service;

import objects.*;
import utils.Generator;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ScheduleService {
    private Schedule schedule = new Schedule();
    private DayService dSvc = new DayService();
    private GroupService gSvc = new GroupService();

    public Schedule initializeSchedule(){
        List<Discipline> disciplines = createSubjects();
        schedule.setDisciplines(disciplines);
        schedule.setLecturers(createLectors());
        schedule.setGroups(createStudentsAndGroup());
        List<Day[]> sch = new ArrayList<Day[]>();
        for (int i = 0; i < 6; i++) {
            sch.add(createDay());
        }
        schedule.setDays(sch);
        return schedule;
    }

    public Day[] createDay() throws NullPointerException{
        List<Lector> lecturers = schedule.getLecturers();
        List<Group> groups = schedule.getGroups();

        Day[] dayForGroup = new Day[4];
        for (int i = 0; i < 4; i++) {       //4 группы
            Day day = new Day();
            for (int j = 0; j < 5; j++) {  //5 пар
                Lector l;
                Discipline d;
                do {
                    l = lecturers.get(Generator.rndNumberInRange(0, lecturers.size()));     //рандомный лектор
                    d = l.getDisciplines().get(Generator.rndNumberInRange(0, 1));           //рандомная дисциплина у лектора
                } while (dSvc.ifLectorHasPair(l, dayForGroup, i, j)&& gSvc.containsDiscipline(groups.get(i), d));  //у лектора в этот день нет пары и у группы не было этого предмета

                if (dSvc.ifLectorHasPair(l, dayForGroup, i, j)){  //окно
                    dSvc.addPair(null, day);
                } else {
                    groups.get(i).removeDiscipline(d);
                    dSvc.addPair(new Pair(d, l, groups.get(i)), day);
                }
            }
            dayForGroup[i] = day;   //массив из дней для каждой группы в определенный день недели
        }
        return dayForGroup;
    }

    private List<Discipline> createSubjects(){
        List<Discipline> disciplines = new ArrayList<Discipline>();
        System.out.println("Создаю предметы...");
        disciplines.add(new Discipline("ТФКП"));
        disciplines.add(new Discipline("Дифференциальные уравнения"));
        disciplines.add(new Discipline("Дискретная математика"));
        disciplines.add(new Discipline("Управление данными"));
        disciplines.add(new Discipline("ООП"));
        disciplines.add(new Discipline("Психология"));
        disciplines.add(new Discipline("Алгебра и геометрия"));
        disciplines.add(new Discipline("Теория вероятностей"));
        disciplines.add(new Discipline("Математический анализ"));
        disciplines.add(new Discipline("АИСД"));
        disciplines.add(new Discipline("Экономика"));
        disciplines.add(new Discipline("История"));

        return disciplines;
    }

    private List<Lector> createLectors(){
        List<Lector> lecturers = new ArrayList<Lector>();
        List<Discipline> disciplines = schedule.getDisciplines();
        Generator gnr = new Generator();
        System.out.println("Созадаю лекторов...");
        for (int i = 0; i < disciplines.size() - 1; i++) {
            Lector lec;
            do {
                lec = new Lector(gnr.createName());
            } while (lecturers.contains(lec));

            lecturers.add(lec);
        }
        int k = 1;
        for (Lector l:lecturers) {
            List<Discipline> ds = new ArrayList<Discipline>();
            ds.add(disciplines.get(k - 1));
            ds.add(disciplines.get(k));
            l.setDisciplines(ds);
            k++;
        }

        return lecturers;
    }

    private List<Group> createStudentsAndGroup(){
        List<Group> groups = new ArrayList<Group>();
        System.out.println("Создаю студентов и группы...");
        Generator gnr = new Generator();

        for (int i = 0; i < 4; i++) {
            ArrayList<Student> students = new ArrayList<Student>();
            for (int j = 0; j < 20; j++) {
                students.add(new Student(gnr.createName()));
            }

            LinkedList<Discipline> disciplinesInGroup = new LinkedList<Discipline>();
            for (Discipline subject : schedule.getDisciplines()) {
                disciplinesInGroup.add(subject);
                disciplinesInGroup.add(subject);
            }
            groups.add(new Group(i, students, disciplinesInGroup));
        }
        return groups;
    }
}