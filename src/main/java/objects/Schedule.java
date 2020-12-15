package objects;

import java.util.ArrayList;
import java.util.List;

public class Schedule {
    private List<Group> groups;
    private List<Discipline> disciplines;
    private List<Lector> lecturers;
    private List<Day[]> days;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Schedule(List<Group> groups, List<Discipline> disciplines, List<Lector> lecturers) {
        this.groups = groups;
        this.disciplines = disciplines;
        this.lecturers = lecturers;
    }

    public Schedule(){
        this.groups = new ArrayList<Group>();
        this.disciplines = new ArrayList<Discipline>();
        this.lecturers = new ArrayList<Lector>();
        this.days = new ArrayList<Day[]>();
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    public List<Discipline> getDisciplines() {
        return disciplines;
    }

    public void setDisciplines(List<Discipline> disciplines) {
        this.disciplines = disciplines;
    }

    public List<Lector> getLecturers() {
        return lecturers;
    }

    public void setLecturers(List<Lector> lecturers) {
        this.lecturers = lecturers;
    }

    public List<Day[]> getDays() {
        return days;
    }

    public void setDays(List<Day[]> days) {
        this.days = days;
    }
}