package net.projecteuler;

import net.projecteuler.utils.Utils;

/*
 * n! means n × (n − 1) × ... × 3 × 2 × 1
 *
 * For example, 10! = 10 × 9 × ... × 3 × 2 × 1 = 3628800,
 * and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.
 *
 * Find the sum of the digits in the number 100!
 */
public class Problem0020 {

  public static void main(String[] args) {

    Utils.stopwatch(Problem0020::first_try);

    simple_loop();
  }

  public static void best_try() {
    // TODO
  }

  public static void first_try() {
    int limit = 300;
    int digit_limit = 4;

    int[] sum = new int[limit];
    sum[limit - 1] = 1;

    for (int i = 2; i <= 100; i++) {

      int n = i;
      int digit_shift = 0;

      int[][] tmp = new int[digit_limit][limit];

      while (n > 0) {
        int r = n % 10;
        if (r > 0) {
          int over = 0;
          for (int j = limit - 1; j > 1; j--) {

            int m = sum[j] * r;

            tmp[digit_shift][j - digit_shift] = (m % 10) + over;

            over = m / 10;
          }
        }
        n = n / 10;

        digit_shift++;
      }
      sum = new int[limit];
      int over = 0;
      for (int j = limit - 1; j > 0; j--) {
        int t_sum = 0;
        for (int k = 0; k < digit_limit; k++) {
          t_sum += tmp[k][j];
        }
        sum[j] = t_sum % 10 + over;
        over = t_sum / 10;
      }
    }

    Utils.print_seq_to_num(sum);
    System.out.println(Utils.sum(sum));
  }

  public static void simple_loop() {
    long sum = 1;
    for (int i = 1; i <= 16; i++) {
      sum = sum * i;
    }

    System.out.println("simple : " + sum);
  }

}
