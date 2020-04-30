package override_overload;

public class ChildClass extends BasicClass {

    @Override
    public String hello(int i){
        return "Overriden!";
    }

    // error! return type is String in basic class
//    @Override
//    public void hello(Integer i){
//        return;
//    }

    public static String staticMethod(){
        return "I'm static in child class!";
    }


    public static String staticMethod(int i){
        return "I'm static: " + i;
    }
}
