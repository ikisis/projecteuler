package net.projecteuler.level001;

import net.projecteuler.utils.Utils;

/*
 * If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9.
 * The sum of these multiples is 23.
 *
 * Find the sum of all the multiples of 3 or 5 below 1000.
 */
public class P0001_MultiplesOf3And5 {

  public static void main(String[] args) {

    Utils.time(P0001_MultiplesOf3And5::brute_force);

    Utils.time(P0001_MultiplesOf3And5::solution);

  }

  public static void brute_force() {

    int sum = 0;

    for (int i = 1; i < 1000; i++) {
      if (i % 3 == 0 || i % 5 == 0) {
        sum += i;
      }
    }

    System.out.println(sum);

  }

  public static void solution() {

    boolean[] checked = new boolean[1001];

    int a = 3, b = 5, sum = 0;

    while (a < 1000) {
      if (!checked[a]) {
        checked[a] = true;
        sum += a;
      }
      a += 3;

      if (b < 1000) {
        if (!checked[b]) {
          checked[b] = true;
          sum += b;
        }
        b += 5;
      }

    }

    System.out.println(sum);

  }

}
