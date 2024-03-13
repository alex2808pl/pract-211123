package de.telran.lesson_6;

public class SimpleLinkedListInt {
    public static void main(String[] args) {
        LinkedListIntSingly list = new LinkedListIntSingly();
        list.add(5);
        list.add(7);
        list.add(9);
        list.add(1);
        list.add(4);
        list.show();

//        list.addFirst(11);
//        list.show();
//        list.delete(9); // удаление из середины
//        list.show();
//        list.delete(11); // удаление с головы
//        list.show();
//        list.delete(4); // удаление последнего
//        list.show();

        list.insert(2,55);
        list.show();

//        LinkedListIntSingly list2 = new LinkedListIntSingly();
//        list2.addFirst(11);
//        list2.show();
//
//        LinkedListIntSingly list3 = new LinkedListIntSingly();
//        list3.show();
    }
}
