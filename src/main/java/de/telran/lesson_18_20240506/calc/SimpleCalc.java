package de.telran.lesson_18_20240506.calc;

public class SimpleCalc {
    public static void main(String[] args) {
        NumericalOperations<Integer> calc = new CalcInteger();
        System.out.println(calc.add(10, 16));
        System.out.println(calc.sub(10, 16));
        System.out.println(calc.multi(10, 16));
        System.out.println(calc.div(10, 16));

        NumericialOperations<Long> calc2 = new CalcLong();
        System.out.println(calc2.add(12L, 2L ));
        System.out.println(calc2.sub(10L, 16L));
        System.out.println(calc2.multi(10L, 16L));
        System.out.println(calc2.div(10L, 16L));

    }
}
