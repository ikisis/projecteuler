package net.projecteuler.level002;

import net.projecteuler.utils.Utils;

/*
 * 145 is a curious number, as 1! + 4! + 5! = 1 + 24 + 120 = 145.
 *
 * Find the sum of all numbers which are equal to the sum of the factorial of their digits.
 *
 * Note: as 1! = 1 and 2! = 2 are not sums they are not included.
 */
public class Problem0034 {

  public static void main(String[] args) {

    Utils.stopwatch(Problem0034::brute_force);
    Utils.stopwatch(Problem0034::first_try);

  }

  public static void brute_force() {
    int result = 0;
    for (int i = 10; i < 2540161; i++) {
      int sumOfFacts = 0;
      int number = i;
      while (number > 0) {
        int d = number % 10;
        number /= 10;
        sumOfFacts += factorial(d);
      }

      if (sumOfFacts == i) {
        result += i;
      }
    }
    System.out.println(result);
  }

  private static int factorial(int x) {
    if (x == 0) {
      return 1;
    }
    int y = x;
    for (int i = 1; i < x; i++) {
      y *= i;
    }
    return y;
  }

  // 5:30
  public static void first_try() {

    int[] facs = new int[10];
    facs[0] = 1; // starter

    for (int i = 1; i < 10; i++) {
      facs[i] = facs[i - 1] * i;

    }

    int limit = facs[9] * 9;

    int total = 0;

    for (int i = 3; i < limit; i++) {
      int fac_sum = 0;

      int n = i;

      while (n > 0) {
        int r = n % 10;
        n = n / 10;

        fac_sum += facs[r];

      }

      if (fac_sum == i) {
        // System.out.println(fac_sum);

        total += i;
      }

    }
    System.out.println(total);

  }

}
