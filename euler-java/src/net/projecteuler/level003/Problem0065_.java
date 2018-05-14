package net.projecteuler.level003;

import java.math.BigInteger;

import net.projecteuler.utils.Utils;

/*
 * Find the sum of digits in the numerator of the 100th convergent of the continued fraction for e.
 *
 */
public class Problem0065_ {

  public static void main(String[] args) {
    Utils.time(Problem0065_::first_try);

    Utils.time(Problem0065_::solution);
  }

  @Deprecated
  public static void first_try() {

    int i = 6;

    i -= 2;

    int n = 0, d = 0, tmp = 0;

    d = i + 1;

    i--;

    n = i * d + i;

    System.out.println(i + " : " + n + "/" + d);

    while (i > 1) {

      i--;

      tmp = n;

      n = d;

      d = tmp;

      n = (i * n) + (i * d);

      System.out.println(i + " : " + n + "/" + d);

    }

    i--;
    tmp = n;
    n = d;
    d = tmp;

    n = d * 2 + n;

    System.out.println(i + " : " + n + "/" + d);

    int gcd = Utils.gcd(n, d);

    System.out.println(n / gcd + " / " + d / gcd);

  }

  public static void solution() {
    int upperbound = 100;
    int result = 0;

    BigInteger d = new BigInteger("" + 1);
    BigInteger n = new BigInteger("" + 2);

    for (int i = 2; i <= upperbound; i++) {
      BigInteger temp = d;
      int cc = (i % 3 == 0) ? 2 * (i / 3) : 1;
      BigInteger c = new BigInteger("" + cc);
      d = n;
      n = c.multiply(d).add(temp);
      System.out.println(n);

    }

    for (char c : n.toString().toCharArray()) {
      result += Integer.parseInt("" + c);
    }

    System.out.println(result);

  }

}
