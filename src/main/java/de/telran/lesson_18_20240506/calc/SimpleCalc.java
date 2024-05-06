package de.telran.lesson_18_20240506.calc;

public class SimpleCalc {
    public static void main(String[] args) {
        NumericalOperations<Integer> calc = new CalcInteger();
        System.out.println(calc.add(10, 16));
        System.out.println(calc.sub(10, 16));
        System.out.println(calc.multi(10, 16));
        System.out.println(calc.div(10, 16));

        NumericalOperations<Short> calcshort = new Calcshort();

        System.out.println(calcshort.add((short) 10, (short) 16));
        System.out.println(calcshort.sub((short) 10, (short) 16));
        System.out.println(calcshort.multi((short) 10, (short) 16));
        System.out.println(calcshort.div((short) 10, (short) 16));
    }
}
