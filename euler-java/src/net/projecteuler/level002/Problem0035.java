package net.projecteuler.level002;

import net.projecteuler.utils.Utils;

/*
 * The number, 197, is called a circular prime because all rotations of the digits: 197, 971, and
 * 719, are themselves prime.
 *
 * There are thirteen such primes below 100: 2, 3, 5, 7, 11, 13, 17, 31, 37, 71, 73, 79, and 97.
 *
 * How many circular primes are there below one million?
 */
public class Problem0035 {

  public static void main(String[] args) {

    Utils.time(Problem0035::first_try);

  }

  public static void first_try() {

    int limit = 1_000_000;
//    int limit = 100;

    boolean[] primes = Utils.primes(limit);

    int count = 4;

    int dc = 2; // digit count;
    int d_ten = 100;
    for (int i = 10; i < limit; i++) {

      if (i % d_ten == 0 && i / d_ten == 1) {
        d_ten *= 10;
        dc++;
      }

      if (!primes[i]) {
        continue;
      }

      int[] digits = new int[dc];
      int n = i;
      int j = 0;
      while (n > 0) {
        int r = n % 10;
        n = n / 10;
        digits[dc - 1 - j] = r;
        j++;
      }

      boolean flag = true;
      for (int k = 0; k < dc; k++) {
        int tmp = digits[0];
        for (int l = 1; l < dc; l++) {
          digits[l - 1] = digits[l];
        }
        digits[dc - 1] = tmp;

        int ten = 1;
        int lotated = 0;
        for (int l = 0; l < dc; l++) {
          lotated += digits[dc - 1 - l] * ten;
          ten *= 10;
        }

        if (!primes[lotated]) {
          flag = false;
          break;
        }
      }
      if (flag) {
        // System.out.println(i);
        count++;
      }

    }

    System.out.println(count);

  }
}
