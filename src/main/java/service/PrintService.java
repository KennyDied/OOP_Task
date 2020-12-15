package service;

import enums.Days;
import json.JSonService;
import objects.*;

import java.text.BreakIterator;
import java.util.Scanner;

public class PrintService {
    private Schedule schedule;
    private JSonService jSonService;

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public PrintService(JSonService jSonService) {
        this.jSonService = jSonService;
    }

    public int chooseInterface() {
        Scanner in = new Scanner(System.in);
        System.out.println("1) Создать расписание.");
        System.out.println("2) Загрузить расписание.");
        int n = in.nextInt();
        return n;
    }

    public String setPath(){
        System.out.print("Путь к файлу: ");
        Scanner wow = new Scanner(System.in);
        return wow.nextLine();
    }
    public void setNameOfSchedule(){
        System.out.println("Название расписания: ");
        Scanner scn = new Scanner(System.in);
        String name = scn.nextLine();
        schedule.setName(name);
    }
    public void textInterface() {
        Scanner in = new Scanner(System.in);

        System.out.println("");
        System.out.println("Что вывести:  ");
        System.out.println("1) Все расписание.");
        System.out.println("2) Расписание для группы.");
        System.out.println("3) Расписание в определенный день для группы.");
        System.out.println("4) Пара для группы по номеру.");
        System.out.println("5) Сохранить расписание.");
        System.out.println("6) Загрузить расписание.");

        System.out.print(">> ");
        int n = in.nextInt();

        if (n == 1) {
            printAll();
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
        }
        if (n == 4) {
            System.out.print("Введите группу (1-4): ");
            int group = in.nextInt();
            System.out.print("Введите день недели (1-6): ");
            int day = in.nextInt();
            System.out.print("Введите номер пары (1-5): ");
            int hour = in.nextInt();
            printScheduleForGroupByHour(group, day, hour);
        }
        if (n == 5) {
            jSonService.toJson(schedule);
        }
        if (n == 6) {
            System.out.print("Путь к файлу: ");
            Scanner wow = new Scanner(System.in);
            String path = wow.nextLine();
            schedule = jSonService.toSchedule(path);
        }
    }

    private void printAll() {
        int numOfDay = 0;
        for (Days day : Days.values()) {
            System.out.println();
            System.out.println("==============");
            System.out.println(day);
            System.out.println("==============");

            System.out.println();
            for (int i = 0; i < 4; i++) {
                System.out.print("        __________________________" + (i + 1) + " группа__________________________        ");
            }
            System.out.println();

            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 4; j++) {
                    String s = schedule.getDays().get(numOfDay)[j].toString(i) + "                                   ";

                    System.out.print(s.substring(0, 77));

                    System.out.print(" | ");
                }
                System.out.println();
            }
            numOfDay++;
        }
    }

    private void printScheduleForGroup(int group) {
        int numOfDay = 0;
        for (Days day : Days.values()) {
            System.out.println();
            System.out.println("==============");
            System.out.println(day);
            System.out.println("==============");
            for (int i = 0; i < 5; i++) {
                String s = schedule.getDays().get(numOfDay)[group].toString(i) + "\n";
                System.out.println(s);
            }
            numOfDay++;
        }
    }

    private void printDayForGroup(int group, int day) {
        System.out.println(schedule.getDays().get(day - 1)[group - 1].toString());
    }

    private void printScheduleForGroupByHour(int group, int day, int hour) {
        System.out.println(schedule.getDays().get(day - 1)[group - 1].toString(hour - 1));

    }
}