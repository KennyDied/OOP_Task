import json.JSonService;
import objects.Schedule;
import service.PrintService;
import service.ScheduleService;

public class Main {
    public static void main(String[] args) {
        JSonService jSonService = new JSonService();
        PrintService ps = new PrintService(jSonService);

        int n = ps.chooseInterface();

        if (n == 1) {
            ScheduleService scheduleService = new ScheduleService();
            Schedule scd = scheduleService.initializeSchedule();

            ps.setSchedule(scd);

            ps.setNameOfSchedule();
        } else {
            ps.setSchedule(jSonService.toSchedule(ps.setPath()));
        }
        while (true) {
            ps.textInterface();
        }
    }
}
