package objects;

public class Pair {
    private Discipline discipline;
    private Lector lector;
    private Group group;

    public Pair(Discipline discipline, Lector lector, Group group) {
        this.discipline = discipline;
        this.lector = lector;
        this.group = group;
    }

    public Discipline getDiscipline() {
        return discipline;
    }

    public void setDiscipline(Discipline discipline) {
        this.discipline = discipline;
    }

    public Lector getLector() {
        return lector;
    }

    public void setLector(Lector lector) {
        this.lector = lector;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return discipline.getNameOfDiscipline() + " - Преподаватель: " + lector.getName() + "  \n";
    }
}