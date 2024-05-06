package de.telran.lesson_18_20240605;
// на основании данного интерфейса разработать калькулятор

//1. Создайте обобщенный интерфейс для калькулятора, в котором будут объявлен перечень операций,
//которые умеет делать ваш калькулятор add, sub, multi и div и реализуйте классы, которые
//будут включать данный интерфейс для работы с различными типами данных аргументов.

public interface NumericalOperations<T extends Number> {
    T add(T a, T b);

    T sub(T a, T b);

    T multi(T a, T b);

    T div(T a, T b);
}
