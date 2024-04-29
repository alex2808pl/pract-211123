package de.telran.lesson_17;

public class Dancer extends  Actor {
    public Dancer(String name, String skills) {
        super(name, skills);
    }
    @Override
    public void showTalants(){
        System.out.println(name  + " dance this art with " + skills);
    }

}
