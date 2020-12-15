package service;

import enums.Hour;
import objects.Day;
import objects.Lector;
import objects.Pair;

public class DayService {
    public void addPair(Pair pair, Day day){
        for (Hour h: Hour.values()) {

            if (!day.getPairMap().containsKey(h)){
                day.getPairMap().put(h, pair);
                return;
            }
        }
    }

    public Pair getPairByHour(Day day, int h){

        for (Hour hour: Hour.values()){
            if (h == hour.getH()) {
                return day.getPairMap().get(h);
            }
        }
        return null;
    }

    public boolean ifLectorHasPair(Lector l, Day[] day, int group, int hour) throws NullPointerException{
        for (int i = group - 1; i >= 0; i--) {
            try {
                if(getPairByHour(day[i], hour).getLector().getName().equals(l.getName())){
                    return true;
                }
            } catch (Exception e) {
                return false;
            }
        }
        return false;
    }

    public Pair getPairByHour(Day day, Hour h){
        day.getPairMap().get(h);
        return null;
    }

    public void addPair(Day day, Pair pair){
        for (Hour h: Hour.values()) {
            if (!day.getPairMap().containsKey(h)){
                day.getPairMap().put(h, pair);
                return;
            }
        }
    }
}
