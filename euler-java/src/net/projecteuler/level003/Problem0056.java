package net.projecteuler.level003;

import java.math.BigInteger;

import net.projecteuler.utils.Utils;

/*
 * A googol (10^100) is a massive number: one followed by one-hundred zeros; 100^100 is almost
 * unimaginably large: one followed by two-hundred zeros. Despite their size, the sum of the digits
 * in each number is only 1.
 *
 * Considering natural numbers of the form, ab, where a, b < 100, what is the maximum digital sum?
 */
public class Problem0056 {

  public static void main(String[] args) {

    Utils.stopwatch(Problem0056::first_try);

  }

  public static void first_try() {

    long max = 0;
    for (int a = 1; a < 100; a++) {
      for (int b = 1; b < 100; b++) {

        BigInteger p = new BigInteger("" + a).pow(b);

        String ps = p.toString();

        long sum = 0;
        for (int i = 0; i < ps.length(); i++) {
          sum += Integer.parseInt("" + ps.charAt(i));
        }

        if (sum > max) {
          max = sum;
        }

      }
    }

    System.out.println(max);

  }

}
