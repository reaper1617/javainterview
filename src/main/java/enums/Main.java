package enums;

public class Main {
    public static void main(String[] args) {


        for (Season s : Season.values()) {
            System.out.println(s);
        }

        for (Season s : Season.values()) {
            System.out.println(s.ordinal());
        }

        for (Season s : Season.values()) {
            System.out.println(s.getDeclaringClass());
        }

        for (Season s : Season.values()) {
            System.out.println(s.name());
        }

        Season s1 = Season.valueOf("WINTER");
        Season s2 = Season.valueOf("FALL");

        Season summer = Season.valueOf("SUMMER");

        switch (s1) {
            case FALL:
                System.out.println("Fall !");
                break;
            case SUMMER:
                System.out.println("Summer!");
                break;
            default:
                System.out.println("Default");
        }


        ExtendedSeason extendedSeason = ExtendedSeason.SPRING;
        extendedSeason.printVisitors();
        ExtendedSeason extendedSeason1 = ExtendedSeason.WINTER;
        extendedSeason1.printVisitors();

        AbstractSeason s = AbstractSeason.FALL;
        s.print();
        AbstractSeason.SUMMER.print();

    }
}
