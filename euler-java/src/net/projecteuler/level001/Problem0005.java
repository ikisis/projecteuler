package net.projecteuler.level001;

import net.projecteuler.utils.Utils;

/*
 * 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any
 * remainder.
 *
 * What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
 */
public class Problem0005 {

  public static void main(String[] args) {

    Utils.time(Problem0005::brute_forced, Problem0005::optimized);

  }

  public static void optimized() {

    int[] primes = new int[20];

    for (int i = 11; i < 20; i++) {

      int[] parts = Utils.doPrimeFactorization(i);

      for (int j = 0; j < parts.length; j++) {
        if (primes[j] < parts[j]) {
          primes[j] = parts[j];
        }
      }

    }

    Utils.prime_factorization_print(primes);

    System.out.println(Utils.reversePrimeFactorization(primes));

  }

  public static void brute_forced() {

    int n = 0;
    for (int i = 1; i < 1000000000; i++) {

      boolean flag = true;

      for (int j = 1; j <= 20; j++) {

        if (i % j != 0) {
          flag = false;
          break;
        }

      }

      if (flag) {
        n = i;
        break;
      }
    }

    System.out.println(n);

  }
}
