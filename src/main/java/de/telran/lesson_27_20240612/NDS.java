package de.telran.lesson_27_20240612;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class NDS implements Callable<Double> {
    private List<Cafe> cafeList;

    public NDS(List<Cafe> cafeList) {
        this.cafeList = cafeList;
    }

    @Override
    public Double call() throws Exception {
        double result;
        int sum = 0;
        for (Cafe elem : cafeList) {
            sum+= elem.getSum();
        }
        result = (sum*0.15);
        return result;
    }
}
