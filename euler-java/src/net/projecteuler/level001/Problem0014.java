package net.projecteuler.level001;

import net.projecteuler.utils.Utils;

/*
 * The following iterative sequence is defined for the set of positive integers:
 *
 * n → n/2 (n is even)
 * n → 3n + 1 (n is odd)
 *
 * Using the rule above and starting with 13, we generate the following sequence:
 *
 * 13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1
 * It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms. Although
 * it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at
 * 1.
 *
 * Which starting number, under one million, produces the longest chain?
 *
 * NOTE: Once the chain starts the terms are allowed to go above one million.
 */
public class Problem0014 {

  public static void main(String[] args) {

    Utils.time(Problem0014::brute_force, Problem0014::memoezation);

  }

  public static void memoezation() {
    int limit = 1_000_000;

    int[] lengths = new int[limit + 1];
    int max = 0;
    int number = 0;
    for (int i = 1; i <= limit; i++) {

      long n = i;
      int len = 1;
      while (n > 1) {

        int in = (int) n;
        if (n < lengths.length && lengths[in] != 0) {

          len = len + lengths[in] - 1;

          break;

        } else {
          if (n % 2 == 0) {
            n = n / 2;
          } else {
            n = 3 * n + 1;
          }
        }

        len++;
      }

      lengths[i] = len;

      if (max < len) {
        max = len;
        number = i;
      }
    }
    System.out.println(max + " : " + number);
    // 525 : 837799
  }

  public static void brute_force() {
//  int limit = 13;
    int limit = 1_000_000;

    int max = 0;
    int number = 0;
    for (int i = 1; i <= limit; i++) {

      long n = i;
      int len = 1;
      while (n > 1) {
        if (n % 2 == 0) {
          n = n / 2;
        } else {
          n = 3 * n + 1;
        }

        len++;
      }
      if (max < len) {
        max = len;
        number = i;
      }
    }
    System.out.println(max + " : " + number);
    // 525 : 837799s
  }

}
