package inner_classes.member_inner_class;

import inner_classes.OuterLevel;
import inner_classes.member_inner_class.Outer;

public class Main {
    public static void main(String[] args) {
        new Outer().callPublicInner();

        Outer outer = new Outer();
        outer.new PublicInner().go();

        new Outer().new PublicInner().go();


        new OuterLevel()
                .new InnerLevel1()
                .new InnerLevel2()
                .new InnerLevel3()
                .new InnerLevel4()
                .new InnerLevel5();


    }
}
