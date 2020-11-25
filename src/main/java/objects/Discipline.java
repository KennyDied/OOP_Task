package objects;


public class Discipline {
    private String nameOfDiscipline;

    public Discipline(String nameOfDiscipline) {
        this.nameOfDiscipline = nameOfDiscipline;
    }

    public String getNameOfDiscipline() {
        return nameOfDiscipline;
    }

    @Override
    public boolean equals(Object obj) {
        Discipline discipline = (Discipline) obj;
        return discipline.nameOfDiscipline.equals(nameOfDiscipline);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
