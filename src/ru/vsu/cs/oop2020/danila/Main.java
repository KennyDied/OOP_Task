package ru.vsu.cs.oop2020.danila;

import ru.vsu.cs.oop2020.danila.utils.Schedule;
import ru.vsu.cs.oop2020.danila.utils.ScheduleService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Schedule scd = new Schedule();
        scd.createSchedule();
        ScheduleService scheduleService = new ScheduleService(scd);

        while(true) {
            System.out.println("");
            System.out.println("Что вывести:  ");
            System.out.println("1) Все расписание.");
            System.out.println("2) Расписание для группы.");
            System.out.println("3) Расписание в определенный день для группы.");
            System.out.println("4) Пара для группы по номеру.");
            System.out.print(">> ");
            int n = in.nextInt();

            if (n == 1) {
                scheduleService.printAll();
            }
            if (n == 2) {
                System.out.print("Введите группу (1-4): ");
                int group = in.nextInt();
                scheduleService.printScheduleForGroup(group);
            }
            if (n == 3) {
                System.out.print("Введите группу (1-4): ");
                int group = in.nextInt();
                System.out.print("Введите день недели (1-6): ");
                int day = in.nextInt();
                scheduleService.printDayForGroup(group, day);
            }
            if (n == 4) {
                System.out.print("Введите группу (1-4): ");
                int group = in.nextInt();
                System.out.print("Введите день недели (1-6): ");
                int day = in.nextInt();
                System.out.print("Введите номер пары (1-5): ");
                int hour = in.nextInt();
                scheduleService.printScheduleForGroupByHour(group, day, hour);
            }
        }
    }
}