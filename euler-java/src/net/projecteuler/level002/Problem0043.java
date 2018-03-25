package net.projecteuler.level002;

import java.util.Arrays;

import net.projecteuler.utils.Utils;

/*
 * The number, 1406357289, is a 0 to 9 pandigital number because it is made up of each of the digits
 * 0 to 9 in some order, but it also has a rather interesting sub-string divisibility property.
 *
 * Let d1 be the 1st digit, d2 be the 2nd digit, and so on. In this way, we note the following:
 *
 * d2d3d4=406 is divisible by 2
 * d3d4d5=063 is divisible by 3
 * d4d5d6=635 is divisible by 5
 * d5d6d7=357 is divisible by 7
 * d6d7d8=572 is divisible by 11
 * d7d8d9=728 is divisible by 13
 * d8d9d10=289 is divisible by 17
 * Find the sum of all 0 to 9 pandigital numbers with this property.
 */
public class Problem0043 {

  public static void main(String[] args) {

    Utils.stopwatch(Problem0043::first_try);

  }

  private static int[] primes = { 2, 3, 5, 7, 11, 13, 17 };

  public static void first_try() {

    int min_limit = 123;
    int max_limit = 9876;

//    int min_limit = 1406;
//    int max_limit = 1406;

    long sum = 0;
    for (int i = min_limit; i <= max_limit; i++) {

      boolean[] pans = new boolean[9 + 1];

      if (i < 1000) {
        pans[0] = true;
      }
      int n = i;
      while (n > 0) {
        int r = n % 10;
        if (pans[r]) {
          break;
        }
        pans[r] = true;
        n /= 10;
      }

      if (n > 0) {
        continue;
      }

//      System.out.println(i);
//      print_pans(pans);

      sum += rec(i, 0, pans);

    }

    System.out.println("result : " + sum);

  }

  public static long rec(long p_num, int prime_index, boolean[] pans) {

    if ((p_num % 1000) % primes[prime_index] != 0) {
      return 0;
    }

    if (prime_index == primes.length - 1) {
      // System.out.println("found !! : " + p_num);
      return p_num;
    }

    long sum = 0;
    for (int i = 0; i < 10; i++) {
      if (!pans[i]) {
        boolean[] new_pans = Arrays.copyOf(pans, pans.length);
        new_pans[i] = true;

        sum += rec((p_num * 10 + i), prime_index + 1, new_pans);
      }
    }

    return sum;
  }

  public static void print_pans(boolean[] pans) {
    for (int i = 0; i < pans.length; i++) {
      System.out.print(i + ":" + pans[i] + " ");
    }
    System.out.println();
  }

}
