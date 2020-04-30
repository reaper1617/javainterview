package instanceof_trick;

public class Main {
    public static void main(String[] args) {
        Hippo hippo = new Hippo();
        Elephant elephant = new Elephant();
        boolean b1 = hippo instanceof Hippo;
        boolean b2 = hippo instanceof Animal;

        // error! inconvertible tyep
//        boolean b3 = hippo instanceof Elephant;



    }
}
