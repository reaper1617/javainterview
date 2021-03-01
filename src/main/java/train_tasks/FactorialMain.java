package train_tasks;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.LongStream;

public class FactorialMain {

    private static final Map<Integer, BigDecimal> CACHE = new HashMap<>();

    public static void main(String[] args) {
        // factorial1
        System.out.println(factorial1(1)); // 1
        System.out.println(factorial1(2)); // 2
        System.out.println(factorial1(3)); // 6
        System.out.println(factorial1(5)); // 120
        System.out.println(factorial1(18)); // -898433024  ????

        // factorial2
        System.out.println(factorial2(1)); // 1
        System.out.println(factorial2(2)); // 2
        System.out.println(factorial2(3)); // 6
        System.out.println(factorial2(5)); // 120
        System.out.println(factorial2(18)); // 6402373705728000
        System.out.println(factorial2(60)); // -8718968878589280256

        // factorial3
        System.out.println(factorial3(1)); // 1
        System.out.println(factorial3(2)); // 2
        System.out.println(factorial3(3)); // 6
        System.out.println(factorial3(5)); // 120
        System.out.println(factorial3(18)); // 6402373705728000
        System.out.println(factorial3(60)); // 8320987112741390144276341183223364380754172606361245952449277696409600000000000000

        // factorial4
        System.out.println(factorial4(1)); // 1
        System.out.println(factorial4(2)); // 2
        System.out.println(factorial4(3)); // 6
        System.out.println(factorial4(5)); // 120
        System.out.println(factorial4(18)); // 6402373705728000
        System.out.println(factorial4(60));
        System.out.println(factorial4(60));

    }

    public static int factorial1(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n should be positive");
        }
        if (n == 0 || n == 1) {
            return 1;
        }
        int f = 1;
        for (int i = 2; i <= n; i++) {
            f = f * i;
        }
        return f;
    }

    public static long factorial2(long n) {
        if (n < 0) {
            throw new IllegalArgumentException("n should be positive");
        }
        if (n == 0 || n == 1) {
            return 1;
        }
        long f = 1;
        for (long i = 2; i <= n; i++) {
            f = f * i;
        }
        return f;
    }

    public static BigDecimal factorial3(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n should be positive");
        }
        if (n == 0 || n == 1) {
            return BigDecimal.ONE;
        }
        BigDecimal f = BigDecimal.ONE;
        BigDecimal N = new BigDecimal(n);
        BigDecimal i = new BigDecimal(2);
        while (i.compareTo(N) <= 0) {
            f = f.multiply(i);
            i = i.add(BigDecimal.ONE);
        }

        return f;
    }

    public static BigDecimal factorial4(Integer n) {
        if (n < 0) {
            throw new IllegalArgumentException("n should be positive");
        }
        if (n == 0 || n == 1) {
            return BigDecimal.ONE;
        }
        if (CACHE.containsKey(n)) {
            System.out.println("Returned cached value " + CACHE.get(n) + " for input: " + n);
            return CACHE.get(n);
        }
        BigDecimal f = BigDecimal.ONE;
        BigDecimal N = new BigDecimal(n);
        BigDecimal i = new BigDecimal(2);
        while (i.compareTo(N) <= 0) {
            f = f.multiply(i);
            i = i.add(BigDecimal.ONE);
        }
        CACHE.putIfAbsent(n, f);
        System.out.println("Returned value " + f + "for input " + n + " and put into cache");
        return f;
    }

    public static long factorial5(long n) {
        if (n < 0) {
            throw new IllegalArgumentException("n should be positive");
        }
        if (n == 0 || n == 1) {
            return 1;
        }
        AtomicLong atomicLong = new AtomicLong(1);
        long f = LongStream.generate(() -> {
    Cloneable
                }
        ).reduce((l1, l2) -> l1 * l2).getAsLong();

    }

}
