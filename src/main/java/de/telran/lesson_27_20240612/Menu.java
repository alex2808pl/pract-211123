package de.telran.lesson_27_20240612;

import java.util.Random;

public enum Menu {
    KITCHEN,
    SNACK,
    ALCOHOL;

    Menu() {

    }

   public static Menu returnRandom() {
        Random random = new Random();
        int num = random.nextInt(3);
        Menu[] menus = Menu.values();
        return menus[num];
    }
}
