package de.telran.lesson_7;

import de.telran.lesson_5.DynamicIntArray;
import de.telran.lesson_6.LinkedListIntSingly;

import java.util.ArrayList;
import java.util.LinkedList;

public class SimpleTestSpeedAddEnd {
    public static void main(String[] args) {

        long startTime, endTime;

        // ArrayList - прогрев
        ArrayList<Integer> arrayList1 = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            arrayList1.add(i);
        }

        // DynamicIntArray
        startTime = System.currentTimeMillis();
        DynamicIntArray dynamicIntArray = new DynamicIntArray();
        for (int i = 0; i < 100000; i++) {
            dynamicIntArray.add(i);
        }
        endTime = System.currentTimeMillis();
        System.out.println("DynamicIntArray add = "+(endTime-startTime));

        // ArrayList
        startTime = System.currentTimeMillis();
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            arrayList.add(i);
        }
        endTime = System.currentTimeMillis();
        System.out.println("ArrayList add = "+(endTime-startTime));

        // LinkedListIntSingly
        startTime = System.currentTimeMillis();
        LinkedListIntSingly linkedListIntSingly = new LinkedListIntSingly();
        for (int i = 0; i < 100000; i++) {
            linkedListIntSingly.add(i);
        }
        endTime = System.currentTimeMillis();
        System.out.println("LinkedListIntSingly add = "+(endTime-startTime));

        //LinkedList
        startTime = System.currentTimeMillis();
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 100000; i++) {
            linkedList.addLast(i);
        }
        endTime = System.currentTimeMillis();
        System.out.println("LinkedList add = "+(endTime-startTime));


//        startTime = System.currentTimeMillis();
//        DynamicIntArray dynamicIntArray1 = new DynamicIntArray();
//        for (int i = 0; i < 100000; i++) {
//            dynamicIntArray1.insert(0,i);
//        }
//        endTime = System.currentTimeMillis();
//        System.out.println("DynamicIntArray insert = "+(endTime-startTime));
    }
}
