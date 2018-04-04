package net.projecteuler.level003;

import java.util.Arrays;

import net.projecteuler.utils.Utils;

/*
 * It can be seen that the number, 125874, and its double, 251748, contain exactly the same digits,
 * but in a different order.
 *
 * Find the smallest positive integer, x, such that 2x, 3x, 4x, 5x, and 6x, contain the same digits.
 */
public class Problem0052 {

  public static void main(String[] args) {
    Utils.stopwatch(Problem0052::first_try);
  }

  public static void first_try() {

    for (int i = 2; i < 1000000; i++) {
      boolean found = true;
      String sorted_a = sortedString(i);
      for (int j = 2; j <= 6; j++) {
        if (!sorted_a.equals(sortedString(i * j))) {
          found = false;
          break;
        }
      }

      if (found) {
        System.out.println(i);
        break;
      }
    }

  }

  public static String sortedString(int i) {
    char[] chars = Integer.toString(i).toCharArray();

    Arrays.sort(chars);

    return new String(chars);
  }

}
