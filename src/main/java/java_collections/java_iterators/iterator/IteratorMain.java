package java_collections.java_iterators.iterator;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class IteratorMain {
    public static void main(String[] args) {

        List<Integer> integerList = List.of(1,2,3,4,5);
        Iterator<Integer> it = integerList.iterator();

        while(it.hasNext()){
            System.out.println(it.next());
        }

    }

    // the same as java.util.Iterator
    interface CustomIterator<E>{
        E next();
        boolean hasNext();
        default void remove(){
            throw new UnsupportedOperationException("remove");
        }
    }

}
