package utils;

import java.util.Random;

public class Generator {
    public String createName(){
        String[] firstName = {"Данила", "Андрей", "Олег", "Артем", "Кирилл", "Дима", "Егор", "Михаил", "Владимир", "Сергей", "Евгений", "Никита", "Степан", "Владислав", "Илья", "Максим", "Денис", "Павел", "Иван", "Александр"};
        String[] lastName = {"Быковский", "Семаков", "Перов", "Боронников", "Зенин", "Мафин", "Беляев", "Ковалев", "Туровский", "Каськов", "Бараков", "Токминин", "Битютских", "Крицкий", "Карасев", "Захарченко", "Шевцов", "Соболев", "Будаев", "Михно"};

        int rndFirstName = new Random().nextInt(firstName.length);
        int rndSecondName = new Random().nextInt(lastName.length);
        return (firstName[rndFirstName] + " " + lastName[rndSecondName]);
    }
     public static int rndNumberInRange(int min, int max) {
        return (int) (Math.random() * (max - min)) + min;
    }
}