package java_enums;

public enum ExtendedSeason {
    WINTER("low", "medium"),
    SPRING("medium"),
    SUMMER("high"),
    FALL("medium");

    private String expectedVisitors;
    private String s2;

    private ExtendedSeason(String s){
        System.out.println("Constructor 1 called!");
        this.expectedVisitors = s;
    }

    private ExtendedSeason(String s, String s2){
        this.expectedVisitors = s;
        this.s2 = s2;
    }

    public void printVisitors(){
        System.out.println("Constructor 2 called!");
        System.out.println(expectedVisitors + " " + s2);
    }
}
