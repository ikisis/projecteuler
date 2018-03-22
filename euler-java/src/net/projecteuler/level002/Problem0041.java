package net.projecteuler.level002;

import net.projecteuler.utils.Utils;

/*
 * We shall say that an n-digit number is pandigital if it makes use of all the digits 1 to n
 * exactly once. For example, 2143 is a 4-digit pandigital and is also prime.
 *
 * What is the largest n-digit pandigital prime that exists?
 */
public class Problem0041 {

  public static void main(String[] args) {

    Utils.stopwatch(Problem0041::first_try);

  }

  public static void first_try() {

    // 1, 2, 3, 4, 5, 6, 7, 8, 9

    // Utils.primes_sieve(987654321);

    int len = 7;

    for (int i = 7654321; i >= 1234567; i -= 2) {
      boolean[] pans = new boolean[len + 1];
      int count = 0;
      int iter = i;
      while (iter > 0) {
        int r = iter % 10;
        if (r == 0 || r > len) {
          break;
        }
        if (!pans[r]) {
          count++;
          pans[r] = true;
        } else {
          break;
        }
        iter /= 10;
      }

      if (len == count && Utils.isPrime(i)) {
        System.out.println(i);
        break;
      }

    }

  }

}
