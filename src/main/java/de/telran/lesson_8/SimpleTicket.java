package de.telran.lesson_8;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SimpleTicket {
    public static void main(String[] args) {
        Set<Ticket> ticketSet = new HashSet<>();
        ticketSet.add(new Ticket(23, "Вася"));
        ticketSet.add(new Ticket(7, "Петя"));
        ticketSet.add(new Ticket(3, "Даша"));
        ticketSet.add(new Ticket(10, "Леша"));
        System.out.println(ticketSet);

        Set<Ticket> ticketSetSort = new TreeSet<>(new Comparator<Ticket>() {
            @Override
            public int compare(Ticket o1, Ticket o2) {
                return o1.num - o2.num;
            }
        });
        ticketSetSort.addAll(ticketSet);
        System.out.println(ticketSetSort);

    }
}
