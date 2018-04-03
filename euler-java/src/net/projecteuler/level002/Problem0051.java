package net.projecteuler.level002;

import net.projecteuler.utils.Utils;

/*
 * By replacing the 1st digit of the 2-digit number *3, it turns out that six of the nine possible
 * values: 13, 23, 43, 53, 73, and 83, are all prime.
 *
 * By replacing the 3rd and 4th digits of 56**3 with the same digit, this 5-digit number is the
 * first example having seven primes among the ten generated numbers, yielding the family: 56003,
 * 56113, 56333, 56443, 56663, 56773, and 56993. Consequently 56003, being the first member of this
 * family, is the smallest prime with this property.
 *
 * Find the smallest prime which, by replacing part of the number (not necessarily adjacent digits)
 * with the same digit, is part of an eight prime value family.
 */
public class Problem0051 {

  public static void main(String[] args) {

    // Utils.stopwatch(Problem0051::first_try);
    Utils.stopwatch(Problem0051::second_try);

  }

  public static void second_try() {

    int limit = 1000000;

    int digit_size = 3;

    int tens = 100;

    for (int i = 100; i < limit; i++) {

      if (i % tens == 0 && i / tens == 10) {
        tens *= 10;
        digit_size++;
      }

      boolean found = false;

      if (Utils.isPrime(i)) {

        int n = i;

        int[] seq = new int[digit_size];

        int seq_i = digit_size - 1;

        while (n > 0) {

          int r = n % 10;
          seq[seq_i--] = r;
          n /= 10;

        }

        // print_used(seq);

        for (int j = 0; j < digit_size; j++) {

          int pick_digit = seq[j];

          int prime_count = 0;
          for (int k = 0; k < 10; k++) {

            int iter_tens = tens;
            int acc = 0;
            seq_i = 0;
            while (iter_tens > 0) {

              int d = seq[seq_i];

              if (d == pick_digit) {
                d = k;
              }

              acc += iter_tens * d;
              seq_i++;

              iter_tens /= 10;

            }
            if (acc >= tens && Utils.isPrime(acc)) {

              prime_count++;
//              System.out
//                  .println(">" + i + "," + j + ",k:" + k + "," + acc + "   picked : " + pick_digit
//                      + "    prime count : " + prime_count);

            }

          }

          if (prime_count >= 8) {
            System.out.println(">%%%%%%%%%%%%%%%%%%%%%%%%%%%%%" + i);
            found = true;
            break;
          }

        }

        if (found) {
          break;
        }

      }

    }

  }

  public static void first_try() {

    int tens = 10;

    int digit_size = 2;

    int[][] used_digit = new int[digit_size][10];

    int limit = 100000;

    for (int i = 10; i <= limit; i++) {

      if (i % tens == 0 && i / tens == 10) {
        tens *= 10;
        // print_used(used_digit);
        digit_size++;
        used_digit = new int[digit_size][10];
      }

      if (Utils.isPrime(i)) {

        int n = i;

        int d = 0;
        while (n > 0) {

          int r = n % 10;
          n /= 10;
          used_digit[d][r] += 1;
          d++;

        }

      }

    }

  }

  private static void print_used(int[] seq) {

    Utils.slowmotion(100);

    System.out.println("----------------");

    for (int i = 0; i < seq.length; i++) {

      System.out.print(seq[i]);

    }
    System.out.println();

  }

}
