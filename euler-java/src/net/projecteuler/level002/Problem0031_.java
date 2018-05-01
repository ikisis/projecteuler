package net.projecteuler.level002;

import net.projecteuler.utils.Utils;

/*
 * In England the currency is made up of pound, £, and pence, p, and there are eight coins in
 * general circulation:
 *
 * 1p, 2p, 5p, 10p, 20p, 50p, £1 (100p) and £2 (200p).
 * It is possible to make £2 in the following way:
 *
 * 1×£1 + 1×50p + 2×20p + 1×5p + 1×2p + 3×1p
 * How many different ways can £2 be made using any number of coins?
 */
public class Problem0031_ {

  public static void main(String[] args) {
    Utils.time(Problem0031_::first_try);
    Utils.time(Problem0031_::reverse_count);

    // TODO recursion

  }

  public static void reverse_count() {
    int m = 200;
    int count = 0;
    int a, b, c, d, e, f, g;
    for (a = m; a >= 0; a -= 200) {
      for (b = a; b >= 0; b -= 100) {
        for (c = b; c >= 0; c -= 50) {
          for (d = c; d >= 0; d -= 20) {
            for (e = d; e >= 0; e -= 10) {
              for (f = e; f >= 0; f -= 5) {
                for (g = f; g >= 0; g -= 2) {
                  count++;
                }
              }
            }
          }
        }
      }
    }
    System.out.println(count);
  }

  public static void first_try() {

//    int sum = 1 * a + 2 * b + 5 * c + 10 * d + 20 * e + 50 * f + 100 * g;

    int count = 1;
    for (int a = 0; a <= 200; a++) {

      for (int b = 0; b <= 100; b++) {
        for (int c = 0; c <= 40; c++) {
          for (int d = 0; d <= 20; d++) {
            for (int e = 0; e <= 10; e++) {
              for (int f = 0; f <= 4; f++) {
                for (int g = 0; g <= 2; g++) {
                  if ((1 * a + 2 * b + 5 * c + 10 * d + 20 * e + 50 * f + 100 * g) == 200) {
                    count++;
                  }

                }
              }
            }
          }
        }
      }
    }

    System.out.println(count);

  }

}
