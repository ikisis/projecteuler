package net.projecteuler.level002;

import java.util.Arrays;

import net.projecteuler.utils.Utils;

/*
 * We shall say that an n-digit number is pandigital if it makes use of all the digits 1 to n
 * exactly once; for example, the 5-digit number, 15234, is 1 through 5 pandigital.
 *
 * The product 7254 is unusual, as the identity, 39 × 186 = 7254, containing multiplicand,
 * multiplier, and product is 1 through 9 pandigital.
 *
 * Find the sum of all products whose multiplicand/multiplier/product identity can be written as a 1
 * through 9 pandigital.
 *
 * HINT: Some products can be obtained in more than one way so be sure to only include it once in
 * your sum.
 */
public class Problem0032 {

  public static void main(String[] args) {

    // System.out.println(99 * 99);
    // 1 * 1111 = 1111
    // 9 * 9999 = 89991

    // 11 * 111 = 1221
    // 99 * 999 = 98901

    Utils.stopwatch(Problem0032::first_try);
  }

  // 8:24
  public static void first_try() {

    /*
     * a * b = c
     * a (100 ~ 999)
     * b (10 ~ 99)
     * c (10000 ~ 99999)
     */

    int sum = 0;

    boolean[] checked = new boolean[9876 + 1];

    for (int a = 1; a <= 9; a++) {

      boolean[] digits = new boolean[9 + 1];

      digits[a] = true;

      for (int b = 1234; b <= 9876; b++) {
        int c = a * b;
        if (c > 1234 && c < 9876) {

          if (!checked[c]) {

            String s = "" + a + b + c;

            Arrays.sort(s.toCharArray());

            char[] cs = s.toCharArray();

            Arrays.sort(cs);

            if (new String(cs).equals("123456789")) {
              checked[c] = true;
              System.out.println(s);
              sum += c;
            }

          }
        }
      }
    }

    for (int a = 12; a <= 98; a++) {

      boolean[] digits = new boolean[9 + 1];

      digits[a % 10] = true;
      digits[a / 10] = true;

      for (int b = 123; b <= 987; b++) {
        int c = a * b;
        if (c > 1234 && c < 9876) {
          if (!checked[c]) {
            String s = "" + a + b + c;

            Arrays.sort(s.toCharArray());

            char[] cs = s.toCharArray();

            Arrays.sort(cs);

            if (new String(cs).equals("123456789")) {
              checked[c] = true;
              System.out.println(s);
              sum += c;

            }
          }
        }
      }
    }

    System.out.println(sum);

  }

}
