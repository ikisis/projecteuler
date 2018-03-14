package net.projecteuler.level001;

import net.projecteuler.utils.Utils;

/*
 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is
 * 13.
 *
 * What is the 10 001st prime number?
 */
public class Problem0007 {

  public static void main(String[] args) {

    int max = 10000000;

    int res = 0;

    boolean[] checked = new boolean[max];

    int count = 1;
    for (int i = 3; i < max; i = i + 2) {

      if (checked[i]) {
        continue;
      }

      boolean flag = true;
      for (int j = 2; j * j < i; j++) {
        if (i % j == 0) {
          flag = false;
          break;
        }
      }

      if (flag) {
        int m = i + i;
        while (m < max) {
          checked[m] = true;
          m = m + i;

        }
        count++;
        if (count == 10001) {
          System.out.println(i);
          res = i;
          break;
        }

      }

    }

    Utils.prime_factorization_print(Utils.doPrimeFactorization(res));

  }

}
