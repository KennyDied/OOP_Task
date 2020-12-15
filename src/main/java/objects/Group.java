package objects;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Group {
    private int idOfGroup;
    private ArrayList<Student> listOfStudents;
    private List<Discipline> disciplinesInGroup;

    public Group(int idOfGroup, ArrayList<Student> listOfStudents, LinkedList<Discipline> disciplinesInGroup) {
        this.idOfGroup = idOfGroup;
        this.listOfStudents = listOfStudents;
        this.disciplinesInGroup = disciplinesInGroup;
    }

    public int getIdOfGroup() {
        return idOfGroup;
    }

    public void setIdOfGroup(int idOfGroup) {
        this.idOfGroup = idOfGroup;
    }

    public List<Student> getListOfStudents() {
        return listOfStudents;
    }

    public void setListOfStudents(ArrayList<Student> listOfStudents) {
        this.listOfStudents = listOfStudents;
    }

    public List<Discipline> getDisciplinesInGroup() {
        return disciplinesInGroup;
    }

    public void setDisciplinesInGroup(List<Discipline> disciplinesInGroup) { this.disciplinesInGroup = disciplinesInGroup; }

    public void removeDiscipline(Discipline d){
        disciplinesInGroup.remove(d);
    }
}
