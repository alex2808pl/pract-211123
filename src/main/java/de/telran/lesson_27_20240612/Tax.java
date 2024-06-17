package de.telran.lesson_27_20240612;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class Tax<L extends List<Cafe>, S extends Number> implements Callable<S> {
    private Supplier<S> cafeInterface;
    private L list;

    public Tax(L list, Supplier<S> cafeInterface) {
        this.cafeInterface = cafeInterface;
        this.list = list;
    }

    @Override
    public S call() throws Exception {
        return cafeInterface.get();
    }
}
