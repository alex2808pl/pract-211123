package de.telran.lesson_7;

import de.telran.lesson_5.DynamicIntArray;
import de.telran.lesson_6.LinkedListIntSingly;

import java.util.ArrayList;
import java.util.LinkedList;

public class SimpleTestSpeedAddBegin {
    public static void main(String[] args) {

        long startTime, endTime;

        // ArrayList -- прогрев JVM
        ArrayList<Integer> arrayList1 = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            arrayList1.addFirst(i);
        }

        // DynamicIntArray
        startTime = System.currentTimeMillis();
        DynamicIntArray dynamicIntArray = new DynamicIntArray();
        for (int i = 0; i < 100000; i++) {
            dynamicIntArray.insert(0,i);
        }
        endTime = System.currentTimeMillis();
        System.out.println("DynamicIntArray add first = "+(endTime-startTime));

        // ArrayList
        startTime = System.currentTimeMillis();
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            arrayList.addFirst(i);
        }
        endTime = System.currentTimeMillis();
        System.out.println("ArrayList add first = "+(endTime-startTime));

        // LinkedListIntSingly
        startTime = System.currentTimeMillis();
        LinkedListIntSingly linkedListIntSingly = new LinkedListIntSingly();
        for (int i = 0; i < 100000; i++) {
            linkedListIntSingly.addFirst(i);
        }
        endTime = System.currentTimeMillis();
        System.out.println("LinkedListIntSingly add first = "+(endTime-startTime));

        //LinkedList
        startTime = System.currentTimeMillis();
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 100000; i++) {
            linkedList.addFirst(i);
        }
        endTime = System.currentTimeMillis();
        System.out.println("LinkedList add first = "+(endTime-startTime));


    }
}
