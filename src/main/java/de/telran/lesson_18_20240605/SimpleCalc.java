package de.telran.lesson_18_20240605;

public class SimpleCalc {
    public static void main(String[] args) {
        NumericalOperations<Integer> calc = new CalcInteger();
        System.out.println(calc.add(10, 15));
        System.out.println(calc.sub(10, 15));
        System.out.println(calc.multi(10, 15));
        System.out.println(calc.div(10, 15));

        System.out.println("-------------");
        NumericalOperations<Float> calc2 = new CalcFloat();
        System.out.println(calc2.add(100.99F, 150.48F));
        System.out.println(calc2.sub(100.99F, 150.48F));
        System.out.println(calc2.multi(100.99F, 150.48F));
        System.out.println(calc2.div(100.99F, 150.48F));

    }
}
