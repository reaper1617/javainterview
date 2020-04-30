package override_overload;

public class BasicClass {

    public String hello(int i){
        return "Hello".concat(" ").concat(String.valueOf(i));
    }

    // overload
    public String hello(Integer i){
        return "Hello".concat(" ").concat(i.toString());
    }

    // overload
    public Float hello(Float i){
        return i;
    }

    // error: already defined!
//    public String hello(int i) throws IllegalAccessException{
//        return "";
//    }

    public static String staticMethod(){
        return "I'm static in basic class !";
    }

    public static String staticMethod(String str){
        return "I'm static!" + str;
    }
}
