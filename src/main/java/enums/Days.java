package enums;

public enum Days {
    Понедельник(1),
    Вторник(2),
    Среда(3),
    Четверг(4),
    Пятница(5),
    Суббота(6);

    private final int d;
    Days(int d) {
        this.d = d;
    }
}