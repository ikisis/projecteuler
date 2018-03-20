package net.projecteuler.level002;

import net.projecteuler.utils.Utils;

/*
 * The number 3797 has an interesting property. Being prime itself, it is possible to continuously
 * remove digits from left to right, and remain prime at each stage: 3797, 797, 97, and 7. Similarly
 * we can work from right to left: 3797, 379, 37, and 3.
 *
 * Find the sum of the only eleven primes that are both truncatable from left to right and right to
 * left.
 *
 * NOTE: 2, 3, 5, and 7 are not considered to be truncatable primes.
 */
public class Problem0037 {

  public static void main(String[] args) {

    Utils.stopwatch(Problem0037::first_try);

  }

  public static void first_try() {

    boolean[] primes = Utils.primes(1000000);

    System.out.println(primes[1]);

    int limit = 1000000;
//    int limit = 200;
    int tens = 10;
    int sum = 0;
    for (int i = 11; i < limit; i += 2) {

      if (i % tens == 1 && i / tens == 10) {
        tens *= 10;
      }

      if (primes[i]) {

        boolean flag = true;
        // L2R
        int ttens = tens;
        int n = i;
        while (ttens > 1 && flag) {
          n = n % ttens;

          if (!primes[n]) {
            flag = false;
          }
          ttens /= 10;
        }

        // R2L
        n = i;
        while (flag && n > 0) {
          if (!primes[n]) {
            flag = false;
          }
          n = n / 10;

        }

        if (flag) {
          System.out.println(i);
          sum += i;
        }

      }
    }

    System.out.println("result : " + sum);

  }

}
