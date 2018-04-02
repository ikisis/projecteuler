package net.projecteuler.level002;

import net.projecteuler.utils.Utils;

/*
 * The prime 41, can be written as the sum of six consecutive primes:
 *
 * 41 = 2 + 3 + 5 + 7 + 11 + 13
 * This is the longest sum of consecutive primes that adds to a prime below one-hundred.
 *
 * The longest sum of consecutive primes below one-thousand that adds to a prime, contains 21 terms,
 * and is equal to 953.
 *
 * Which prime, below one-million, can be written as the sum of the most consecutive primes?
 */
public class Problem0050 {

  public static void main(String[] args) {
    Utils.stopwatch(Problem0050::first_try);
  }

  public static void first_try() {

    int limit = 1000000;
    int[] prime_seq = new int[limit];
    boolean[] checked = new boolean[limit];
    int size = 0;
    for (int i = 0; i < limit; i++) {
      if (Utils.isPrime(i)) {
        // System.out.println(i);
        prime_seq[size] = i;
        checked[i] = true;
        size++;
      }
    }

    int max_len = 0;
    int max_len_prime = 0;
    for (int i = 0; i < size; i++) {
      int sum = 0;
      int len = 0;

      for (int j = i; j < size; j++) {
        sum += prime_seq[j];
        // System.out.println(sum);
        if (sum >= limit) {
          break;
        }
        len++;
        if (checked[sum]) {
          if (max_len < len) {
            max_len = len;
            max_len_prime = sum;
          }
        }
      }

    }

    System.out.println(max_len + ", " + max_len_prime);

  }

}
