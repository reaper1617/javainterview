package java_basics;

public class Primitives {

    public static void main(String[] args) {

        // TYPES //
        byte b = 1;           // 1 byte, [-128, 127]
        short sh = 3;         // 2 bytes [-32768, 32767]
        int i = 5;            // 4 bytes [-2147483648,2147483648 ]
        long l = 48574;       // 8 bytes [-9223372036854775808,9223372036854775807]
        char c = '1';         // Unicode, 2 bytes
        float f = 0.3f;       // 4 bytes
        double d = 5.4;       // 8 bytes, Double.MAX_VALUE = 0x1.fffffffffffffP+1023
        boolean bool = false; // depends on JVM, int used

        // TYPE TRANSFORMATION //

        int a = 474545;
        double doubleVal = a; // hidden transformation

        byte byteVal = (byte)a; // implicit transf
        System.out.println("int a == " + a + " byte byteVal == " + byteVal);

        // TRANSFORM RULES:
        //byte, short, char в выражениях всегда повышаются до int
        //если в выражении участвует тип long — то именно к этому типу будет приведён результат
        //если в выражении участвует float — то результат приводится к float
        //если один из операндов имеет тип double — то к этому типу будет приведён весь результат
        //При выборе между длиной и возможностью сохранить дробную часть — будет выбрана дробная часть
    }
}
