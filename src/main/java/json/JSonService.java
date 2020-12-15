package json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import objects.Schedule;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

public class JSonService {
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public void toJson(Schedule schedule){
        String json = gson.toJson(schedule);
        File file = new File("./Schedules/" + schedule.getName());

        if(!file.exists()){
            while (!file.mkdir()){
                System.out.println("Не получилось создать папку! пробую ещё раз.");
            }
        }

        file = new File("./Schedules/" + schedule.getName() + ".json");

        try {
            file.createNewFile();
            FileWriter fw = new FileWriter(file);
            fw.write(json);
            fw.flush();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Schedule toSchedule(String path){
        String json = "";
        try {
            FileInputStream inFile = new FileInputStream(path);
            byte[] str = new byte[inFile.available()];
            inFile.read(str);
            json = new String(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return gson.fromJson(json, Schedule.class);
    }
}
