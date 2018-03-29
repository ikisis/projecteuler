package net.projecteuler.level002;

import net.projecteuler.utils.Utils;

/*
 * The first two consecutive numbers to have two distinct prime factors are:
 *
 * 14 = 2 × 7
 * 15 = 3 × 5
 *
 * The first three consecutive numbers to have three distinct prime factors are:
 *
 * 644 = 2² × 7 × 23
 * 645 = 3 × 5 × 43
 * 646 = 2 × 17 × 19.
 *
 * Find the first four consecutive integers to have four distinct prime factors each. What is the
 * first of these numbers?
 */
public class Problem0047_ {

  public static void main(String[] args) {
    Utils.stopwatch(Problem0047_::first_try);
  }

  public static void first_try() {

    int limit = 1000000;
    int len = 4;
    for (int i = 644; i < limit; i++) {
      boolean flag = true;
      for (int j = i; j < (i + len); j++) {
        if (Utils.isPrime(j)) {
          flag = false;
          break;
        }
        int[] fac = Utils.doPrimeFactorization(j);
        int count = 0;
        for (int k = 0; k < fac.length; k++) {
          if (fac[k] > 0) {
            count++;
          }
        }

        if (count != len) {
          flag = false;

          break;
        }

      }
      if (flag) {
        System.out.println(">>" + i);
        break;
      }

    }

  }

}
