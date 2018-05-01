package net.projecteuler.level002;

import java.util.Arrays;

import net.projecteuler.utils.Utils;

/*
 * The arithmetic sequence, 1487, 4817, 8147, in which each of the terms increases by 3330, is
 * unusual in two ways: (i) each of the three terms are prime, and, (ii) each of the 4-digit numbers
 * are permutations of one another.
 *
 * There are no arithmetic sequences made up of three 1-, 2-, or 3-digit primes, exhibiting this
 * property, but there is one other 4-digit increasing sequence.
 *
 * What 12-digit number do you form by concatenating the three terms in this sequence?
 */
public class Problem0049 {

  public static void main(String[] args) {
    Utils.time(Problem0049::first_try);
  }

  public static void first_try() {

    int count = 0;
    int[] primes = new int[9999];
    boolean[] prime_grid = new boolean[9999];
    for (int i = 1000; i < 9999; i++) {
      if (Utils.isPrime(i)) {
        primes[count] = i;
        prime_grid[i] = true;
        count++;
      }
    }

    for (int i = 0; i < count; i++) {
      int a = primes[i];
      int a_sorted = sorted(a);

      for (int j = i + 1; j < count - 2; j++) {
        int b = primes[j];
        if (sorted(b) == a_sorted) {
          int c = b + b - a;
          if (c >= 9999) {
            continue;
          }
          if (prime_grid[c] && a_sorted == sorted(c)) {
            System.out.println(a + "," + b + "," + c + " += " + a + "" + b + "" + c);
          }
        }
      }
    }

  }

  public static int sorted(int n) {
    int[] as = new int[4];
    int i = 0;
    while (n > 0) {
      as[as.length - 1 - i] = n % 10;
      n /= 10;
      i++;
    }
    Arrays.sort(as);
    return as[0] * 1000 + as[1] * 100 + as[2] * 10 + as[3];
  }

}
