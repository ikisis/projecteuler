package net.projecteuler.level002;

import net.projecteuler.utils.Utils;

/*
 * It was proposed by Christian Goldbach that every odd composite number can be written as the sum
 * of a prime and twice a square.
 *
 * 9 = 7 + 2×1^2
 * 15 = 7 + 2×2^2
 * 21 = 3 + 2×3^2
 * 25 = 7 + 2×3^2
 * 27 = 19 + 2×2^2
 * 33 = 31 + 2×1^2
 *
 * It turns out that the conjecture was false.
 *
 * What is the smallest odd composite that cannot be written as the sum of a prime and twice a
 * square?
 */
public class Problem0046 {

  public static void main(String[] args) {

    Utils.stopwatch(Problem0046::first_try);

  }

  public static void first_try() {

    int limit = 10000;
    int square_limit = 40;
    for (int i = 3; i < limit; i += 2) {

      if (!Utils.isPrime(i)) {
        int j = 1;
        for (; j < square_limit; j++) {
          int n = i - (2 * (j * j));
          if (n < 0) {
            j = square_limit;
            break;
          }
          if (Utils.isPrime(n)) {
            break;
          }
        }
        // System.out.println(j);
        if (j == square_limit) {
          System.out.println("found : " + i);
          break;
        }
      }

    }

  }

}
