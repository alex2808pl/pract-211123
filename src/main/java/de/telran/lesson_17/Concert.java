package de.telran.lesson_17;

import java.util.Arrays;
import java.util.List;

public class Concert<T extends Actor> {
    private List<T> t;

    public Concert(T... t) {
        this.t = Arrays.stream(t).toList();
    }

    public Concert(List<T> t) {
        this.t = t;
    }

    public void process() {
        for (T talant : t) {
            talant.showTalants();

        }
    }


}
