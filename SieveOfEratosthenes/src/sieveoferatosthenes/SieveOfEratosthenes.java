package sieveoferatosthenes;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author CISCO
 */
public class SieveOfEratosthenes {

    private static ArrayList<Integer> primes = new ArrayList<Integer>();
    private static ArrayList<Long> primeFactors = new ArrayList<Long>();
    private static int MAX = 1000;
    private static boolean sieve[] = new boolean[MAX + 5];
    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        double c = scan.nextInt();
        long N = 1;
        for (int i = 2; i <= c; i++) {
            N *= i;
        }
        System.out.println("N = "+N);

        calculatePrimes();
        calculatePrimeFactors(N);
        
        for (int j = 0; primes.get(j) == N; j++) {
            System.out.println("P" + j + ": " + primes.get(j) + " ");
        }

    }

    public static void calculatePrimeFactors(long value) {
        primeFactors.clear();
        long temp = value;
        int factor;

        for (int i = 0; (long) primes.get(i) * primes.get(i) <= value; ++i) {
            factor = primes.get(i);

            while (temp % factor == 0) {
                primeFactors.add((long) factor);
                temp /= factor;
            }
        }

        if (temp != 1) {
            primeFactors.add(temp);
        }

    }

    public static void calculatePrimes() {

        sieve[0] = sieve[1] = true;

        int i;
        for (i = 2; i * i <= MAX; ++i) {

            if (!sieve[i]) {
                primes.add(i);
            }

            for (int j = i * i; j <= MAX; j += i) {
                sieve[j] = true;
            }
        }

        for (; i <= MAX; i++) {

            if (!sieve[i]) {
                primes.add(i);
            }
        }

        
    }

}
