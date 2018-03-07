package net.projecteuler.utils;

public class Utils {

  public static int reversePrimeFactorization(int[] primes) {

    int res = 1;
    for (int i = 0; i < primes.length; i++) {
      if (primes[i] > 0) {
        int n = 1;
        for (int j = 0; j < primes[i]; j++) {
          n = n * i;
        }

        res = res * n;
      }
    }

    return res;
  }

  public static int[] doPrimeFactorization(int n) {

    int[] primes = new int[n + 1];

    int acc = n;

    for (int i = 2; i <= acc;) {
      if (acc % i == 0) {
        acc = acc / i;
        primes[i] = primes[i] + 1;
        i = 2;
      } else {
        i++;
      }
    }

    return primes;
  }

  public static int[] primes() {

    int[] primes = new int[20];

    int size = 0;
    for (int i = 2; i <= 20; i++) {
      boolean flag = true;
      for (int j = 2; j < i; j++) {
        if (i % j == 0) {
          flag = false;
          break;
        }
      }

      if (flag) {
        primes[size++] = i;
      }
    }

    return primes;

  }

  public static void prime_factorization_print(int[] primes) {
    boolean flag = true;
    for (int i = 0; i < primes.length; i++) {

      if (primes[i] != 0) {
        if (flag) {
          flag = false;
        } else {
          System.out.print(" x ");

        }
        System.out.print(i);
        if (primes[i] > 1) {
          System.out.print("^" + primes[i]);
        }
      }
    }
    System.out.println();
  }
}
