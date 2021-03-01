package java_functional_interfaces;

public class Main {

    @FunctionalInterface
    interface Sprint{
        public void sprint(Object o);
    }


    static class Tiger implements Sprint{

        @Override
        public void sprint(Object o) {
            System.out.println("Tiger sprint!");
        }
    }

    public static void main(String[] args) {


        new Tiger().sprint(new Object());


    }
}
