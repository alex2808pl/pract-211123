package de.telran.lesson_27_20240612;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class Cafe  {
private String name;
private Menu menu;
private int sum;

    public Cafe(String name, Menu menu, int sum) {
        this.name = name;
        this.menu = menu;
        this.sum = sum;
    }

    public Cafe() {
        this.name = UUID.randomUUID().toString();
        this.menu = Menu.returnRandom();
        this.sum = generateSum();
    }

   private int generateSum(){
        Random random = new Random();
        int sum= random.nextInt(10,100);
        return sum;
   }

    @Override
    public String toString() {
        return "Cafe{" +
                "name='" + name + '\'' +
                ", menu=" + menu +
                ", sum=" + sum +
                '}';
    }

    public int getSum() {
        return sum;
    }

    public Menu getMenu() {
        return menu;
    }
}
