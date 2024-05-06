package de.telran.lesson_18_20240506.calc;


public class Calcshort implements NumericalOperations<Short> {

    @Override
    public Short add(Short a, Short b) {
        return (short) (a + b);
    }

    @Override
    public Short sub(Short a, Short b) {
        return (short) (a - b);
    }

    @Override
    public Short multi(Short a, Short b) {
        return (short) (a * b);
    }

    @Override
    public Short div(Short a, Short b) {
        if (b == 0) {
            throw new ArithmeticException("Деление на ноль не допускается.");
        }
        return (short) (a / b);
    }
}