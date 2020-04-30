package inner_classes.local_inner_class;

public class Outer {

    private int length = 5;

    public void calculate(){

        // should be effectively final as it used in local inner class
        int width = 20;

        // no access specifier!
        // can not be static
        // have access to all fields and methods of the enclosing class
        class Inner{
            public void multiply(){
                System.out.println(length * width);
            }
        }

        Inner inner = new Inner();
        inner.multiply();
        // error in #17: should be effectively final!
        //width ++;
    }

}
