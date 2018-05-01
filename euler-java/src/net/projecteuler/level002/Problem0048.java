package net.projecteuler.level002;

import net.projecteuler.utils.Utils;

/*
 * The series, 1^1 + 2^2 + 3^3 + ... + 10^10 = 10405071317.
 *
 * Find the last ten digits of the series, 1^1 + 2^2 + 3^3 + ... + 1000^1000.
 */
public class Problem0048 {

  public static void main(String[] args) {

    Utils.time(Problem0048::first_try);

    // System.out.println(Long.MAX_VALUE % 10000000000L);
  }

  public static void first_try() {

    int limit = 1000;

    long result = 0;
    for (int n = 1; n <= limit; n++) {
      long sp = 1;
      for (int p = 0; p < n; p++) {
        sp *= n;
        sp %= 10000000000L;
      }
      result += sp;
    }

    System.out.println(result % 10000000000L);

  }

}
