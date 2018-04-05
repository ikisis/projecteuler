package net.projecteuler.level003;

import java.math.BigInteger;

import net.projecteuler.utils.Utils;

/*
 * There are exactly ten ways of selecting three from five, 12345:
 *
 * 123, 124, 125, 134, 135, 145, 234, 235, 245, and 345
 *
 * In combinatorics, we use the notation, 5C3 = 10.
 *
 * In general,
 *
 * nCr =
 * n!/r!(n−r)!
 * ,where r ≤ n, n! = n×(n−1)×...×3×2×1, and 0! = 1.
 * It is not until n = 23, that a value exceeds one-million: 23C10 = 1144066.
 *
 * How many, not necessarily distinct, values of nCr, for 1 ≤ n ≤ 100, are greater than one-million?
 */
public class Problem0053_ {

  public static void main(String[] args) {

//    int n = 23;
//    int r = 10;
//
//    BigInteger nCr = fac(n).divide(fac(r).multiply(fac(n - r)));
//
//    System.out.println(nCr);
//
//    System.out.println(nCr.compareTo(new BigInteger("1000000")));

    Utils.stopwatch(Problem0053_::first_try);

  }

  public static void first_try() {

    int count = 0;
    for (int n = 1; n <= 100; n++) {

      for (int r = 2; r <= n; r++) {

//        long nCr = fac(n) / fac(r) * fac(n - r);

        BigInteger nCr = fac(n).divide(fac(r).multiply(fac(n - r)));

        if (nCr.compareTo(new BigInteger("1000000")) == 1) {
          // count += (n - r) + 1;
          // break;
          count++;
        }

      }

    }

    System.out.println(count);

  }

  private static BigInteger[] facs = new BigInteger[100 + 1];

  public static BigInteger fac(int n) {

    if (n == 0) {
      return new BigInteger("1");
    }

    if (facs[n] != null) {
      return facs[n];
    }

    BigInteger f = new BigInteger("1");

    for (int i = 1; i <= n; i++) {
      f = f.multiply(new BigInteger(Integer.toString(i)));
      // System.out.println(f);
      facs[i] = f;
    }

    return f;

  }

}
