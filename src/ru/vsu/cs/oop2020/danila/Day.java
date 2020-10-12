package ru.vsu.cs.oop2020.danila;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Day {
    private Map<Hour, Pair> pairMap;
    private enum Hour{Первая, Вторая, Третья, Четвертая, Пятая ,Шестая;

    };

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
                p.printPair();
            }
        }

    }



}