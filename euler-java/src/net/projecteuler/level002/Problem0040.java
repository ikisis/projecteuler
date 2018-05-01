package net.projecteuler.level002;

import net.projecteuler.utils.Utils;

/*
 * An irrational decimal fraction is created by concatenating the positive integers:
 *
 * 0.12345678910'1'112131415161718192021...
 *
 * It can be seen that the 12th digit of the fractional part is 1.
 *
 * If dn represents the nth digit of the fractional part, find the value of the following
 * expression.
 *
 * d1 × d10 × d100 × d1000 × d10000 × d100000 × d1000000
 */
public class Problem0040 {

  public static void main(String[] args) {
    Utils.time(Problem0040::first_try);
  }

  public static void first_try() {

    int n = 0;

    int i = 0;

    int tens = 1;
    int i_tens = 1;
    int res = 1;
    while (n <= 1000000) {

      i++;
      if (i % i_tens == 0 && i / i_tens == 10) {
        i_tens *= 10;

      }

      int iter = i;
      int iter_tens = i_tens;
      while (iter_tens >= 1) {
        n++;
        if (n % tens == 0 && n / tens == 1) {

          tens *= 10;
          System.out.println(iter / iter_tens + ", n = " + n);

          res *= (iter / iter_tens);
        }
        iter = (iter % iter_tens);
        iter_tens /= 10;
      }

    }

    System.out.println("result : " + res);

  }

}
