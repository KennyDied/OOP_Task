package service;

import objects.Discipline;
import objects.Group;

import java.util.List;

public class GroupService {
    public void removeDiscipline(Group group, Discipline d){
        group.getDisciplinesInGroup().remove(d);
    }

    public boolean containsDiscipline(Group group, Discipline d){
        List<Discipline> disciplinesInGroup = group.getDisciplinesInGroup();

        for (Discipline dis:disciplinesInGroup) {
            if (dis.equals(d)){
                return true;
            }
        }
        return false;
    }
}