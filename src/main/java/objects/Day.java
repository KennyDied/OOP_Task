package objects;

import enums.Hour;

import java.util.HashMap;
import java.util.Map;

public class Day {
    private Map<Hour, Pair> pairMap;

    public Day(){
        this.pairMap = new HashMap<Hour, Pair>();
    }

    public Map<Hour, Pair> getPairMap() {
        return pairMap;
    }

    public void setPairMap(Map<Hour, Pair> pairMap) {
        this.pairMap = pairMap;
    }

    public void addPair(Pair pair){
        for (Hour h: Hour.values()) {
            if (!pairMap.containsKey(h)){
                pairMap.put(h, pair);
                return;
            }
        }
    }

    @Override
    public String toString() {                      //весь день
        StringBuilder str = new StringBuilder();
        for (Hour h: Hour.values()) {
            Pair p = pairMap.get(h);
            if (pairMap.containsKey(h)){
                str.append(h).append(" пара: ");
                if (p == null){
                    str.append("окно\n");
                } else {
                    str.append(p.toString());
                }
            }
        }
        return String.valueOf(str);
    }

    public String toString(int i) {                 //на конкретный час дня
        StringBuilder str = new StringBuilder();

        int k = 0;
        for (Hour h: Hour.values()){
            if (k == i) {
                str.append(h).append(" пара: ");
                Pair p = pairMap.get(h);
                str.append(p.toString());
            }
            k++;
        }
        return String.valueOf(str);
    }
}