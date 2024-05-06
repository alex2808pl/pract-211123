package de.telran.lesson_18_20240506.calc;

public class SimpleCalc {
    public static void main(String[] args) {
        NumericalOperations<Integer> calc = new CalcInteger();
        System.out.println(calc.add(10, 16));
        System.out.println(calc.sub(10, 16));
        System.out.println(calc.multi(10, 16));
        System.out.println(calc.div(10, 16));

        NumericalOperations<Double> calculator3 = new CalcDouble();
        System.out.println(calculator3.add(10.5, 15.6));
        System.out.println(calculator3.sub(10.5, 15.6));
        System.out.println(calculator3.multi(10.5, 15.6));
        System.out.println(calculator3.div(10.5, 15.6));
        System.out.println("-------------");

        NumericalOperations<Float> calc2 = new CalcFloat();
        System.out.println(calc2.add(100.99F, 150.48F));
        System.out.println(calc2.sub(100.99F, 150.48F));
        System.out.println(calc2.multi(100.99F, 150.48F));
        System.out.println(calc2.div(100.99F, 150.48F));

    }
}
