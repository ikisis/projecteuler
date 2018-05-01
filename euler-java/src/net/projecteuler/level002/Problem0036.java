package net.projecteuler.level002;

import java.util.Arrays;

import net.projecteuler.utils.Utils;

/*
 * The decimal number, 585 = 1001001001 (binary), is palindromic in both bases.
 *
 * Find the sum of all numbers, less than one million, which are palindromic in base 10 and base 2.
 *
 * (Please note that the palindromic number, in either base, may not include leading zeros.)
 */
public class Problem0036 {

  public static void main(String[] args) {

    Utils.print_seq_to_num(calc(10, 585));
    Utils.print_seq_to_num(calc(2, 585));

    System.out.println(isPalindromic(calc(10, 585)));
    System.out.println(isPalindromic(calc(2, 585)));

    Utils.time(Problem0036::first_try);

  }

  public static void first_try() {

    int limit = 1_000_000;
    int sum = 0;
    for (int i = 1; i < limit; i++) {
      if (isPalindromic(calc(10, i)) && isPalindromic(calc(2, i))) {
        System.out.println(i);
        Utils.print_seq_to_num(calc(2, i));
        sum += i;
      }
    }

    System.out.println("result = " + sum);

  }

  public static int[] calc(int d, int number) {

    int limit = 100;
    int[] seq = new int[limit];
    int n = number;
    int size = 0;
    while (n > 0) {
      seq[limit - 1 - size] = n % d;
      n = n / d;
      size++;
    }

    int[] ret = Arrays.copyOfRange(seq, limit - size, limit);

    return ret;

  }

  public static boolean isPalindromic(int[] seq) {
    boolean flag = true;

    int half = seq.length / 2 + 1;

    for (int i = 0; i < half; i++) {
      if (seq[i] != seq[seq.length - 1 - i]) {
        flag = false;
        break;
      }
    }

    return flag;
  }

}
