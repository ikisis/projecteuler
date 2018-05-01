package net.projecteuler.level003;

import java.math.BigInteger;

import net.projecteuler.utils.Utils;

/*
 * It is possible to show that the square root of two can be expressed as an infinite continued
 * fraction.
 *
 * √ 2 = 1 + 1/(2 + 1/(2 + 1/(2 + ... ))) = 1.414213...
 *
 * By expanding this for the first four iterations, we get:
 *
 * 1 + 1/2 = 3/2 = 1.5
 * 1 + 1/(2 + 1/2) = 7/5 = 1.4
 * 1 + 1/(2 + 1/(2 + 1/2)) = 17/12 = 1.41666...
 * 1 + 1/(2 + 1/(2 + 1/(2 + 1/2))) = 41/29 = 1.41379...
 *
 * The next three expansions are 99/70, 239/169, and 577/408, but the eighth expansion, 1393/985, is
 * the first example where the number of digits in the numerator exceeds the number of digits in the
 * denominator.
 *
 * In the first one-thousand expansions, how many fractions contain a numerator with more digits
 * than denominator?
 */
public class Problem0057 {

  public static void main(String[] args) {

    Utils.time(Problem0057::first_try);

  }

  public static void first_try() {

    int count = 0;
    for (int i = 1; i <= 1000; i++) {
      BigInteger[] f = f(i);

      // System.out.println(i + " : " + f[0] + "/" + f[1]);

      if (f[0].toString().length() > f[1].toString().length()) {
        count++;
      }
    }

    System.out.println(count);

  }

  // 1 + 1 / 2 = 3, 2
  // 1 + 1 / (2 + 1 / 2) = 7, 5

  // n = 1, d = 2
  // 1 + 1 / f
  // f = 2 + 1/f

  public static BigInteger[] f(int expansions) {

    BigInteger[] r = f0(expansions - 1);

    // 1/f
    BigInteger n = r[1];
    BigInteger d = r[0];

    n = n.add(d);

    return new BigInteger[] { n, d };

  }

  public static BigInteger[] f0(int expansions) {

    if (expansions == 0) {
      return new BigInteger[] { new BigInteger("2"), new BigInteger("1") };
    }

    BigInteger[] r = f0(expansions - 1);

    // 1/f
    BigInteger n = r[1];
    BigInteger d = r[0];

    n = n.add(d.multiply(new BigInteger("2")));

    return new BigInteger[] { n, d };

  }

}
