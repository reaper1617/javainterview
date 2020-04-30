package inner_classes.anon_classes;

public class Main {


    abstract static class ExampleOne{
        abstract void doThing();
    }

    interface ExampleTwo{
        void doThing();
    }

    public static void main(String[] args) {


        ExampleOne one = new ExampleOne(){
            void doThing(){
                System.out.println("Example one from abstract class!");
            }
        };


        ExampleTwo two = () -> System.out.println("Example two from interface!");

        one.doThing();
        two.doThing();


    }
}
