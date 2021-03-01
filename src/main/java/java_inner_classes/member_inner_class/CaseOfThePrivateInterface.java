package java_inner_classes.member_inner_class;

class CaseOfThePrivateInterface {

    private interface Secret{
        public void shh();
    }


    class DontTell implements Secret{

        @Override
        public void shh() {

        }

    }

}
