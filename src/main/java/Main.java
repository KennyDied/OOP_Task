import objects.Schedule;
import service.PrintService;
import service.ScheduleService;

import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        ScheduleService scheduleService = new ScheduleService();
        Schedule scd = scheduleService.initializeSchedule();
        PrintService printService = new PrintService(scd);
        while(true) {
            printService.textInterface(in);
        }
    }
}
