package de.telran.lesson_17;

public abstract class Actor {
    public String name;
    public String skills;

    public Actor(String name, String skills) {
        this.name = name;
        this.skills = skills;
    }

    abstract void showTalants();
}


