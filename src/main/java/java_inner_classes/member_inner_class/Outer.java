package java_inner_classes.member_inner_class;

public class Outer {

    private String outerString = "outerString";

    public class PublicInner{
        public int repeat = 3;
        public void go(){
            for (int i = 0; i < repeat; i++) {
                System.out.println("Public inner: " + i + " " + outerString);
            }
        }

    }

    public void callPublicInner(){
        new PublicInner().go();
    }


    protected class ProtectedInner{

    }

    private class PrivateInner{

    }

    class DefaultInner{

    }
}
