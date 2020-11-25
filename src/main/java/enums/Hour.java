package enums;

public enum Hour {
    Первая(1),
    Вторая(2),
    Третья(3),
    Четвертая(4),
    Пятая(5),
    Шестая(6);

    private final int h;
    Hour(int h) {
        this.h = h;
    }

    public int getH() {
        return h;
    }
}
