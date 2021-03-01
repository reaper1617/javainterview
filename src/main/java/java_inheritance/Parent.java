package java_inheritance;

public class Parent {

    private String privateField;
    protected String protectedField;
    public String publicField;

    private void privateMethod(){
        System.out.println("Parent class: Private method invoked");
    }

    protected void protectedMethod(){
        System.out.println("Parent class: Protected method invoked");
    }

}
