package net.projecteuler.level002;

import net.projecteuler.utils.Utils;

/*
 * Surprisingly there are only three numbers that can be written as the sum of fourth powers of
 * their digits:
 *
 * 1634 = 1^4 + 6^4 + 3^4 + 4^4
 * 8208 = 8^4 + 2^4 + 0^4 + 8^4
 * 9474 = 9^4 + 4^4 + 7^4 + 4^4
 * As 1 = 1^4 is not a sum it is not included.
 *
 * The sum of these numbers is 1634 + 8208 + 9474 = 19316.
 *
 * Find the sum of all the numbers that can be written as the sum of fifth powers of their digits.
 */
public class Problem0030 {

  public static void main(String[] args) {
    Utils.stopwatch(Problem0030::first_try);
  }

  public static void first_try() {

    int p = 5;
    int limit = 1000000;
    int total = 0;
    for (int i = 2; i < limit; i++) {
      int sum = 0;
      int n = i;
      while (n > 0) {
        int t = n % 10;
        // if(t == 1)
        n = n / 10;
        int e = 1;
        for (int j = 0; j < p; j++) {
          e *= t;
        }
        sum += e;
      }

      if (i == sum) {
        // System.out.println(i);
        total += sum;
      }

    }

    System.out.println("total : " + total);

  }

}
