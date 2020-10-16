package ru.vsu.cs.oop2020.danila.utils;

import ru.vsu.cs.oop2020.danila.objects.Day;

import java.util.List;

public class ScheduleService {
    private Schedule schedule;
    private List<Day[]> fullSchedule;
    private enum Days{Понедельник, Вторник, Среда, Четверг, Пятница, Суббота}


    public ScheduleService(Schedule schedule) {
        this.schedule = schedule;
        this.fullSchedule = schedule.getDays();
    }

    public void printAll(){
        int numOfDay = 0;
        for (Days day:Days.values()) {
            System.out.println("==============");
            System.out.println(day);
            System.out.println("==============");
            for (int i = 0; i < 4; i++) {
                System.out.println("___" + (i + 1) + " группа___");
                fullSchedule.get(numOfDay)[i].printPairs();
            }
            numOfDay++;
        }
    }

    public void printDayForGroup(int group, int day){
        fullSchedule.get(day - 1)[group - 1].printPairs();
    }

    public void printScheduleForGroup(int group){
        for (Day[] d: fullSchedule) {
            System.out.println();
            d[group - 1].printPairs();
        }
    }

    public void printScheduleForGroupByHour(int group, int day, int hour){
        fullSchedule.get(day - 1)[group - 1].printPairByHour(hour - 1);
    }
}