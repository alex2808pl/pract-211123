package de.telran.lesson_6;

public class LinkedListIntSingly {
    private Node head;
    private int size;

    public int getSize() {
        return size;
    }

    public void add(int element) {  // добавление в конец
        Node newNode = new Node();
        newNode.setData(element);
        if(head == null) {
            head = newNode;
        }
        else {
            Node node = head;
            while (node.getNext()!=null) {
                node = node.getNext();
            }
            node.setNext(newNode);
        }
        size++;
    }

    public void show() {
        Node node = head;
        StringBuilder outStr = new StringBuilder("[");
        do {
            outStr.append(node.getData()+",");
            node = node.getNext();
        }
        while (node.getNext()!=null);
        outStr.append(node.getData()+"]");
        System.out.println(outStr);
    }
}
