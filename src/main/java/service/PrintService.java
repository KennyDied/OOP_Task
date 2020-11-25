package service;

import enums.Days;
import objects.*;

import java.util.Scanner;

public class PrintService {
    private Schedule schedule;

    public PrintService(Schedule schedule) {
        this.schedule = schedule;
    }

    public void textInterface(Scanner in){
        System.out.println("");
        System.out.println("Что вывести:  ");
        System.out.println("1) Все расписание.");
        System.out.println("2) Расписание для группы.");
        System.out.println("3) Расписание в определенный день для группы.");
        System.out.println("4) Пара для группы по номеру.");
        System.out.print(">> ");
        int n = in.nextInt();

        if (n == 1) {
            printAll();
            //scheduleService.printAll();
        }
        if (n == 2) {
            System.out.print("Введите группу (1-4): ");
            int group = in.nextInt();
            printScheduleForGroup(group);
        }
        if (n == 3) {
            System.out.print("Введите группу (1-4): ");
            int group = in.nextInt();
            System.out.print("Введите день недели (1-6): ");
            int day = in.nextInt();
            printDayForGroup(group, day);
            //scheduleService.printDayForGroup(group, day);
        }
        if (n == 4) {
            System.out.print("Введите группу (1-4): ");
            int group = in.nextInt();
            System.out.print("Введите день недели (1-6): ");
            int day = in.nextInt();
            System.out.print("Введите номер пары (1-5): ");
            int hour = in.nextInt();
            printScheduleForGroupByHour(group, day, hour);
            //scheduleService.printScheduleForGroupByHour(group, day, hour);
        }
    }


    private void printAll(){
        int numOfDay = 0;
        for (Days day:Days.values()) {
            System.out.println("==============");
            System.out.println(day);
            System.out.println("==============");
            for (int i = 0; i < 4; i++) {
                System.out.println("___" + (i + 1) + " группа___");
                System.out.println(schedule.getDays().get(numOfDay)[i].toString());
            }
            numOfDay++;
        }
    }

    private void printScheduleForGroup(int group){
        for (Day[] d: schedule.getDays()) {
            System.out.println();
            System.out.println(d[group - 1].toString());
        }
    }


    private void printDayForGroup(int group, int day){
        System.out.println(schedule.getDays().get(day - 1)[group - 1].toString());
    }

    private void printScheduleForGroupByHour(int group, int day, int hour){
        System.out.println(schedule.getDays().get(day - 1)[group - 1].toString(hour - 1));

    }
}