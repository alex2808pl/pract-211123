package de.telran.lesson_17;

import java.util.List;

public class SimpleConcert {
    public static void main(String[] args) {
        Singer singer1 = new Singer("Elvis", "sings");
        Singer singer2 = new Singer("Madonna", "sings");
        Singer singer3 = new Singer("Beyoncé", "sings");
        singer1.eat();

        Dancer dancer1 = new Dancer("Peter","dances");
        Dancer dancer2 = new Dancer("Beyoncé","dances");
        Dancer dancer3 = new Dancer("Ilina","dances");

        List<Actor> concert1 = List.of(dancer1,dancer2,dancer3, singer1,singer2,singer3);
        Concert<Actor> concerts = new Concert<>(concert1);
        concerts.process();
        System.out.println("--------------");
        Concert <Actor> concert2 = new Concert<>(dancer1,singer3,dancer2);
        concert2.process();


//        Concert<Actor> concert =  new Concert<>(singer1);
//        Concert<Actor> concert2 =  new Concert<>(dancer2);
//        Concert<Actor> concert3 =  new Concert<>(dancer3);
//        concert.process();
//        concert2.process();
//        concert3.process();

    }
}
