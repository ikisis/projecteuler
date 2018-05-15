package net.projecteuler.level003;

import java.math.BigInteger;

import net.projecteuler.utils.Utils;

/*
 * Find the sum of digits in the numerator of the 100th convergent of the continued fraction for e.
 *
 */
public class Problem0065_ {

  public static void main(String[] args) {

    // Utils.time(Problem0065_::first_try);

    Utils.time(Problem0065_::second_try);

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

  public static void second_try() {

    Integer i = 100;

    i -= 2;

    BigInteger numerator = BigInteger.valueOf(find_a(i + 1)), denomirator = BigInteger.valueOf(1);

    for (; i >= 0; i--) {

      Integer a = find_a(i);

      BigInteger tmp = numerator;

      numerator = numerator.multiply(BigInteger.valueOf(a)).add(denomirator);

      denomirator = tmp;

    }

    System.out.println(">>" + numerator + "/" + denomirator);

    int digit_sum = 0;
    for (Character c : numerator.toString().toCharArray()) {
      digit_sum += Integer.parseInt(c.toString());
    }

    System.out.println(digit_sum);

  }

  public static Integer find_a(int i) {
    if (i == 0) {
      return 2;
    }

    return i % 3 == 2 ? ((i / 3) + 1) * 2 : 1;
  }

}
