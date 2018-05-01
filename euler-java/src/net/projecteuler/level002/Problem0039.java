package net.projecteuler.level002;

import net.projecteuler.utils.Utils;

/*
 * If p is the perimeter of a right angle triangle with integral length sides, {a,b,c}, there are
 * exactly three solutions for p = 120.
 *
 * {20,48,52}, {24,45,51}, {30,40,50}
 *
 * For which value of p ≤ 1000, is the number of solutions maximised?
 */
public class Problem0039 {

  public static void main(String[] args) {

    Utils.time(Problem0039::first_try);

    // System.out.println(20 * 20 + 48 * 48 == 52 * 52);

  }

  public static void first_try() {

    // a^2 + b^2 = c^2

    int max_p = 0;
    int max_s = 0;
    for (int p = 4; p <= 1000; p++) {
      int solutions = 0;
      for (int c = p - 2; c > 1; c--) {
        for (int a = 1; a + c < p - 1; a++) {
          int b = p - c - a;
          if (b < a) {
            break;
          }

          if (a * a + b * b == c * c) {
            System.out.println(p + " : " + a + "," + b + "," + c);
            solutions++;
            if (solutions > max_s) {
              max_p = p;
              max_s = solutions;
            }
          }
        }
      }

    }

    System.out.println(">> result : " + max_p + ", " + max_s);

  }

}
