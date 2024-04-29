package de.telran.lesson_17;

public class Singer extends  Actor{
    public Singer(String name, String skills) {
        super(name, skills);
    }

    @Override
    public void showTalants(){
        System.out.println(name  + " realisieren this skill" + skills);
    }
    public void eat(){
        System.out.println(name +" eats");
    }

}
