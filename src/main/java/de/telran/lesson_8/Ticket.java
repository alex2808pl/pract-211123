package de.telran.lesson_8;

public class Ticket {
    int num;
    String fio;

    public Ticket(int num, String fio) {
        this.num = num;
        this.fio = fio;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "num=" + num +
                ", fio='" + fio + '\'' +
                '}';
    }
}
