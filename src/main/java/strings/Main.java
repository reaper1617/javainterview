package strings;

public class Main {
    public static void main(String[] args) {
        String s1 = new String("lion");
        String s2 = new String("lion");
        String s3 = "lion";
        String s4 = "lion";
        System.out.println(s1 == s2); //false
        System.out.println(s1.equals(s2)); //true
        System.out.println(s3 == s2); //false
        System.out.println(s3 == s4); //true : string pool
    }
}
