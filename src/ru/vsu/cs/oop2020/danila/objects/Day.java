package ru.vsu.cs.oop2020.danila.objects;

import java.util.HashMap;
import java.util.Map;

public class Day {
    private enum Hour{Первая, Вторая, Третья, Четвертая, Пятая ,Шестая};
    private Map<Hour, Pair> pairMap;

    public Day(){
        this.pairMap = new HashMap<Hour, Pair>();
    }

    public void addPair(Pair pair){
        for (Hour h: Hour.values()) {
            if (!pairMap.containsKey(h)){
                pairMap.put(h, pair);
                return;
            }
        }
    }

    public void printPairs(){
        for (Hour h: Hour.values()) {
            Pair p = pairMap.get(h);
            if (pairMap.containsKey(h)){
                System.out.print(h + " пара: ");
                if (p == null){
                    System.out.println("окно");
                } else {
                    p.printPair();
                }
            }
        }
    }

    public void printPairByHour(int i){
        int k = 0;
        for (Hour h: Hour.values()){
            if (k == i) {
                System.out.print(h + " пара: ");
                Pair p = pairMap.get(h);
                p.printPair();
            }
            k++;
        }
    }

    public Pair getPairByHour(int i){
        int k = 0;
        for (Hour h: Hour.values()){
            if (k == i) {
                return pairMap.get(h);
            }
            k++;
        }
        return null;
    }
}