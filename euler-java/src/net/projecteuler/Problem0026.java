package net.projecteuler;

import net.projecteuler.utils.Utils;

/*
 * A unit fraction contains 1 in the numerator. The decimal representation of the unit fractions
 * with denominators 2 to 10 are given:
 *
 * 1/2 = 0.5
 * 1/3 = 0.(3)
 * 1/4 = 0.25
 * 1/5 = 0.2
 * 1/6 = 0.1(6)
 * 1/7 = 0.(142857)
 * 1/8 = 0.125
 * 1/9 = 0.(1)
 * 1/10 = 0.1
 * Where 0.1(6) means 0.166666..., and has a 1-digit recurring cycle. It can be seen that 1/7 has a
 * 6-digit recurring cycle.
 *
 * Find the value of d < 1000 for which 1/d contains the longest recurring cycle in its decimal
 * fraction part.
 */
public class Problem0026 {

  public static void main(String[] args) {

    Utils.stopwatch(Problem0026::first_try);

    double n = 1, d = 999;
    System.out.println(n / d);
    System.out.println(1d / 998d);
    System.out.println(1d / 19d);
    System.out.println(1d / 983d);

  }

  public static void first_try() {
    int t = 10;
    int decimal_base = 0;
    int max_r = 0;
    int max_r_d = 0;
    for (int denominator = 2; denominator < 1000; denominator++) {

      int limit = 3000;
      int[] decimals = new int[limit];

      int numerator = t;

      int remainder = 0;

      int index = 0;

      while (decimal_base + index < limit) {

        int current = decimal_base + index;

        int quotient = numerator / denominator;

        decimals[current] = quotient;

        if (remainder != 0 && remainder == numerator % denominator) {
          break;
        }

        if (current > 3 && current % 2 == 0) {
          int len = current / 2;
          boolean flag = true;
          for (int i = 0; i < len; i++) {
            if (decimals[i] != decimals[i + len]) {
              flag = false;
            }
          }

          if (flag) {
            if (max_r < len) {
              max_r = len;
              max_r_d = denominator;
              // System.out.println(denominator + ", " + len);

            }
            break;
          }
        }

        remainder = numerator % denominator;

        index++;

        if (remainder == 0) {
          break;
        }
        numerator = remainder * 10;
      }

      // support(denominator, index, decimal_base, decimals);
      if (denominator % t == 0) {
        t *= 10;
        decimal_base++;
      }

    }

    System.out.println(max_r_d + ",," + max_r);
  }

  public static void support(int denominator, int index, int decimal_s, int[] decimals) {
    System.out.print(denominator + ":" + index + " d: " + decimal_s + " > ");
    for (int i = 0; i < index; i++) {
      System.out.print(decimals[i]);
    }
    System.out.println();
  }

}
