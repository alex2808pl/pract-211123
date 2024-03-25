package de.telran.lesson_8;

import java.util.Comparator;

public class AutoCompare implements Comparator<Auto> {
    @Override
    public int compare(Auto o1, Auto o2) {
//        return o1.getManufactureYear() - o2.getManufactureYear();
        if(o1.getManufactureYear() < o2.getManufactureYear())
            return -1;
        if(o1.getManufactureYear() > o2.getManufactureYear())
            return 1;
        else return 0;

    }
}
