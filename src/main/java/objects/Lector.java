package objects;

import java.util.List;

public class Lector {
    private String name;
    private List<Discipline> disciplines;

    public Lector(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Discipline> getDisciplines() {
        return disciplines;
    }

    public void setDisciplines(List<Discipline> disciplines) {
        this.disciplines = disciplines;
    }
}