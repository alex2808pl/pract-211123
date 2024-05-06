package de.telran.lesson_18_20240506.calc;

public class SimpleCalc {
    public static void main(String[] args) {
        NumericalOperations<Integer> calc = new CalcInteger();
        System.out.println(calc.add(10, 16));
        System.out.println(calc.sub(10, 16));
        System.out.println(calc.multi(10, 16));
        System.out.println(calc.div(10, 16));
    }
}
