package net.projecteuler.level001;

import net.projecteuler.utils.Utils;

/*
 * A palindromic number reads the same both ways. The largest palindrome made from the product of
 * two 2-digit numbers is 9009 = 91 × 99.
 *
 * Find the largest palindrome made from the product of two 3-digit numbers.
 */
public class Problem0004 {

  public static void main(String[] args) {

    solved2_WIP();

  }

  public static void solved2_WIP() {

    int a = 1, b = 1, c = 1;

    int res1 = 100000 * a + 10000 * b + 1000 * c + 100 * c + 10 * b + a;

    int res2 = 100001 * a + 10010 * b + 1100 * c;

    System.out.println(Utils.gcd(100001, 10010, 1100));
    // 11

    System.out.println(100001 / 11);
    System.out.println(10010 / 11);
    System.out.println(1100 / 11);

    int res3 = 11 * (9091 * a + 910 * b + 100 * c);

    System.out.println(res1 == res2 && res2 == res3);

  }

  public static void solved1() {
    int a = 999, b = 999;

    int max = 0;

    for (int i = 0; i < a; i++) {

      for (int j = 0; j < b; j++) {

        int number = (a - i) * (b - j);

        int[] tokens = new int[10];

        int size = 0;

        int iter = number;

        while (iter > 0) {
          tokens[size] = iter % 10;
          iter = iter / 10;
          size++;
        }

        int m = size / 2 + 1;

        int index = 0;

        for (index = 0; index < m; index++) {
          if (tokens[index] != tokens[size - index - 1]) {
            break;
          }
        }

        if (index == m) {
          if (number > max) {
            max = number;
          }
        }
      }
    }

    System.out.println(max);
  }

}
