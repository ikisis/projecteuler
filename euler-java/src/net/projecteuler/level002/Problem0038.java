package net.projecteuler.level002;

import net.projecteuler.utils.Utils;

/*
 * Take the number 192 and multiply it by each of 1, 2, and 3:
 *
 * 192 × 1 = 192
 * 192 × 2 = 384
 * 192 × 3 = 576
 * By concatenating each product we get the 1 to 9 pandigital, 192384576. We will call 192384576 the
 * concatenated product of 192 and (1,2,3)
 *
 * The same can be achieved by starting with 9 and multiplying by 1, 2, 3, 4, and 5, giving the
 * pandigital, 918273645, which is the concatenated product of 9 and (1,2,3,4,5).
 *
 * What is the largest 1 to 9 pandigital 9-digit number that can be formed as the concatenated
 * product of an integer with (1,2, ... , n) where n > 1?
 */
public class Problem0038 {

  public static void main(String[] args) {

    Utils.stopwatch(Problem0038::first_try);

    System.out.println(9327 * 1 + "" + 9327 * 2);

  }

  public static void first_try() {

    int limit = 100000;

    int max = 0;

    for (int i = 1; i < limit; i++) {
      boolean[] pans = new boolean[10];

      int count = 0;

      int concat = 0;

      int j = 1;
      for (j = 1; j < limit; j++) {

        if (count == 9) {
          break;
        }
        int n = i * j;

        while (n > 0) {
          int r = n % 10;
          if (r == 0) {
            count = -1;
            break;
          }

          if (!pans[r]) {
            pans[r] = true;
            count++;
          } else {
            count = -1;
            break;
          }

          n /= 10;
        }

        if (count == -1) {
          break;
        }

      }

      if (count == 9) {
        int digit = 1;
        for (int k = j - 1; k > 0; k--) {
          int p = i * k;
          while (p > 0) {
            concat += (p % 10) * digit;
            p /= 10;
            digit *= 10;
          }
        }
        if (max < concat) {
          max = concat;
        }
        System.out.println(i + "," + (j - 1) + ", " + concat);
      }
    }

    System.out.println("max concat : " + max);
  }

  /*
   * 99999 * 1 = 99999
   */

}
