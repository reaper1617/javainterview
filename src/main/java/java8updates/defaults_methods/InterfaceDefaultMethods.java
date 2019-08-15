package java8updates.defaults_methods;

public class InterfaceDefaultMethods implements InterfaceWithDefaults {
    public static void main(String[] args) {
        InterfaceWithDefaults interfaceWithDefaults = new InterfaceDefaultMethods();
        System.out.println(interfaceWithDefaults.sqrt(4));
    }

    @Override
    public String returnString() {
        return null;
    }
}
