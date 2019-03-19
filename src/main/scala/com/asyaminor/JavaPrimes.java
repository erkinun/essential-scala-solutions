package com.asyaminor;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JavaPrimes {

    // generate primes
    static List<Integer> generate(int limit) {
        Stream<Integer> infinity = Stream.iterate(1, i -> i + 1);
        return infinity.filter(JavaPrimes::isPrime).limit(limit).collect(Collectors.toList());
    }

    // is prime
    static boolean isPrime(int num) {
        if (num == 1) { return false; }
        else if (num == 2) { return true; }
        else {
            double fermatNum = Math.pow(2, num - 1) - 1;
            return fermatNum % num == 0;
        }
    }

    // main
    public static void main(String[] args) {
        List<Integer> primes = generate(20);
        for (int p : primes) {
            System.out.print(p);
            System.out.print(", ");
        }
        System.out.println();
    }
}
