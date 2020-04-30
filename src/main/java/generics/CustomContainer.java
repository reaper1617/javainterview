package generics;

import java.util.Arrays;

public class CustomContainer<E> {

    // compile error!
    //E[] data = new E[10];
    private Object[] data;


    public CustomContainer(E[] data) {
        this.data = data;
    }

    public void printData(){
        System.out.println("Data: " + Arrays.toString(data));
    }

    private void testConstructorRestrinctions(){
        // compile error!
        //E el = new E();
    }
}
