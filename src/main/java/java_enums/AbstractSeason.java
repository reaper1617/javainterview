package java_enums;

public enum AbstractSeason {
    WINTER {
        @Override
        public void print() {
            System.out.println("It's winter!");
        }
    },

    SPRING {
        @Override
        public void print() {
            System.out.println("It's spring!");
        }
    },
    SUMMER {
//        @Override
//        public void print() {
//            System.out.println("It's summer!");
//        }
    },
    FALL {
        @Override
        public void print() {
            System.out.println("It's autumn!");
        }
    };

    public void print() {
        System.out.println("Default");
    }
}
