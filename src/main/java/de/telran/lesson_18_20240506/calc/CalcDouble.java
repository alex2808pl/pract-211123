package de.telran.lesson_18_20240506.calc;

public class CalcDouble implements NumericalOperations<Double> {
    @Override
    public Double add(Double a, Double b) {
        return a + b;
    }

    @Override
    public Double sub(Double a, Double b) {
        return a - b;
    }

    @Override
    public Double multi(Double a, Double b) {
        return a * b;
    }

    @Override
    public Double div(Double a, Double b) {
        if (b == 0) {
            System.out.println("Operation is not possible");
            return null;
        } else return a / b;
    }
}
