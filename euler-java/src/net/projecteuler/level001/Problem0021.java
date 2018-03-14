package net.projecteuler.level001;

import net.projecteuler.utils.Utils;

/*
 * Let d(n) be defined as the sum of proper divisors of n (numbers less than n which divide evenly
 * into n).
 * If d(a) = b and d(b) = a, where a ≠ b, then a and b are an amicable pair and each of a and b are
 * called amicable numbers.
 *
 * For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44, 55 and 110; therefore
 * d(220) = 284. The proper divisors of 284 are 1, 2, 4, 71 and 142; so d(284) = 220.
 *
 * Evaluate the sum of all the amicable numbers under 10000.
 */
public class Problem0021 {

  public static void main(String[] args) {

    Utils.stopwatch(Problem0021::first_try);
  }

  public static void first_try() {
    boolean[] used = new boolean[10001];
    int sum = 0;
    for (int i = 1; i <= 10000; i++) {
      if (used[i]) {
        continue;
      }

      int d = d(i);

      if (d == i) {
        continue;
      }

      int d2 = d(d);

      if (d2 == i) {
        System.out.println(i + "," + d + " are amicable!");
        sum += (i + d);
        used[d] = true;
      }

    }
    System.out.println(sum);
  }

  public static int d(int n) {
    int sum = 0;
    for (int i = 1; i < n; i++) {
      if (n % i == 0) {
        sum += i;
      }
    }

    return sum;
  }

}
