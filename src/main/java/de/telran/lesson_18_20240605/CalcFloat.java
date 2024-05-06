package de.telran.lesson_18_20240605;

public class CalcFloat implements NumericalOperations<Float>{
    @Override
    public Float add(Float a, Float b) {
        return a+b;
    }

    @Override
    public Float sub(Float a, Float b) {
        return a-b;
    }

    @Override
    public Float multi(Float a, Float b) {
        return a*b;
    }

    @Override
    public Float div(Float a, Float b) {
        return a-b;
    }
}
