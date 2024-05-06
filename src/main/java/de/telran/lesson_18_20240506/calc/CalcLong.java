package de.telran.lesson_18_20240506.calc;

public class CalcLong implements NumericialOperations<Long> {
    @Override
    public Long add(Long a, Long b) {
        return a + b;
    }

    @Override
    public Long sub(Long a, Long b) {
        return a - b;
    }

    @Override
    public Long multi(Long a, Long b) {
        return a * b;
    }

    @Override
    public Long div(Long a, Long b) {
        if(b == 0){
            throw new ArithmeticException( "Divivsion by zero");
        }
        return a / b;
    }
}
