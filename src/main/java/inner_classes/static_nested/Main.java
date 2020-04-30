package inner_classes.static_nested;

public class Main {


    static class Nested{
        private int price = 9;
    }

    public static void main(String[] args) {

        Nested nested = new Nested();
        System.out.println(nested.price);
    }
}
