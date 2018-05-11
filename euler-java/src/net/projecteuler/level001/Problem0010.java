package net.projecteuler.level001;

import net.projecteuler.utils.Utils;

/*
 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
 *
 * Find the sum of all the primes below two million.
 */
public class Problem0010 {

  public static void main(String[] args) {

    Utils.time(Problem0010::solution);

  }

  public static void solution() {
    int limit = 2_000_000;

    boolean[] checked = new boolean[limit];

    long sum = 2;

    for (int i = 3; i < limit; i = i + 2) {
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

        sum = sum + i;
        int acc = i;
        while (acc < limit) {
          checked[acc] = true;
          acc += i;
        }
        // System.out.println(i);

      }

    }

    System.out.println(sum);
  }

}
