package Fibonacci;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;


public class Main {
    public static void main(String[] args) {

        BiFunction<Integer, Map<Integer, Long>, Long> fibonacci = new BiFunction<>() {
            @Override
            public Long apply(Integer n, Map<Integer, Long> memo) {

                if(memo.containsKey(n))
                    return memo.get(n);

                if(n <= 2)
                    return 1L;

                memo.put(n, (this.apply(n - 1, memo) + this.apply(n - 2, memo)));

                return memo.get(n);
            }
        };

        System.out.println(fibonacci.apply(6, new HashMap())); //8
        System.out.println(fibonacci.apply(7, new HashMap())); //13
        System.out.println(fibonacci.apply(8, new HashMap())); //21
        System.out.println(fibonacci.apply(50, new HashMap())); //12586269025

    }
}