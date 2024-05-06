package de.telran.lesson_18_20240605;

public class CalcInteger implements NumericalOperations<Integer>{
    @Override
    public Integer add(Integer a, Integer b) {
        return a+b;
    }

    @Override
    public Integer sub(Integer a, Integer b) {
        return a-b;
    }

    @Override
    public Integer multi(Integer a, Integer b) {
        return a*b;
    }

    @Override
    public Integer div(Integer a, Integer b) {
        return a/b;
    }
}
