package java_collections.java_iterators.list_iterator;

import java.util.List;
import java.util.ListIterator;

public class ListIteratorMain {


    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4, 5);

        ListIterator<Integer> it = list.listIterator();

        while (it.hasNext()) {
            System.out.println("==============================================================");
            Integer cur = it.next();
            System.out.println("Has Next: " + it.hasNext());
            System.out.println("Current: " + cur);
            System.out.println("Next index: " + it.nextIndex());
            Integer prev = it.previous();
            System.out.println("Has previous: " + it.hasPrevious());
            System.out.println("Now current: " + prev);
            System.out.println("Previous index: " + it.previousIndex());

            it.next(); // should be called because call to 'previous()' move caret backwards
            System.out.println("==============================================================");
        }
    }


    // the same as java.util.ListIterator
    interface CustomListIterator<E> {
        boolean hasNext();

        E next();

        boolean hasPrevious();

        E previous();

        int nextIndex();

        int previousIndex();

        void remove();

        void set(E e);
    }
}
