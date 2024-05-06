package de.telran.lesson_18_20240506.calc;

public class SimpleCalc {
    public static void main(String[] args) {
        NumericalOperations<Integer> calc = new CalcInteger();
        System.out.println(calc.add(10, 16));
        System.out.println(calc.sub(10, 16));
        System.out.println(calc.multi(10, 16));
        System.out.println(calc.div(10, 16));

        NumericalOperations<Short> calc1 = new Calcshort();

        System.out.println(calc1.add((short) 10, (short) 16));
        System.out.println(calc1.sub((short) 10, (short) 16));
        System.out.println(calc1.multi((short) 10, (short) 16));
        System.out.println(calc1.div((short) 10, (short) 16));
    }
}
