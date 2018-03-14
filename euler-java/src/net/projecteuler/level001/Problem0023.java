package net.projecteuler.level001;

import net.projecteuler.utils.Utils;

/*
 * A perfect number is a number for which the sum of its proper divisors is exactly equal to the
 * number. For example, the sum of the proper divisors of 28 would be 1 + 2 + 4 + 7 + 14 = 28, which
 * means that 28 is a perfect number.
 *
 * A number n is called deficient if the sum of its proper divisors is less than n and it is called
 * abundant if this sum exceeds n.
 *
 * As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16, the smallest number that can be
 * written as the sum of two abundant numbers is 24. By mathematical analysis, it can be shown that
 * all integers greater than 28123 can be written as the sum of two abundant numbers. However, this
 * upper limit cannot be reduced any further by analysis even though it is known that the greatest
 * number that cannot be expressed as the sum of two abundant numbers is less than this limit.
 *
 * Find the sum of all the positive integers which cannot be written as the sum of two abundant
 * numbers.
 */
public class Problem0023 {
  public static void main(String[] args) {

    Utils.stopwatch(Problem0023::first_try);

  }

  public static void first_try() {

    int limit = 28123 + 1;

    boolean[] abundant = new boolean[limit];

    for (int i = 12; i < limit; i++) {

      int sum = 0;
      for (int j = 1; j < i; j++) {
        if (i % j == 0) {
          sum += j;
        }
      }
      if (i < sum) {
        abundant[i] = true;
      }
    }

    long sum = 0;
    for (int i = 1; i < 24; i++) {
      sum += i;
    }
    for (int i = 25; i < limit; i++) {
      boolean not_abundant_sum = false;

      for (int j = 12; j < i; j++) {
        if (abundant[j]) {
          int r = i - j;
          if (abundant[r]) {
            not_abundant_sum = true;
            break;
          }
        }
      }
      if (!not_abundant_sum) {
        // System.out.println(i);
        sum += i;
      }
    }

    System.out.println(sum);
    // 395465536 x
    // 39545296975

  }

}
