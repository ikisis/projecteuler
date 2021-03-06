package net.projecteuler.level002;

import net.projecteuler.utils.Utils;

/*
 * Triangle, pentagonal, and hexagonal numbers are generated by the following formulae:
 *
 * Triangle Tn=n(n+1)/2 1, 3, 6, 10, 15, ...
 * Pentagonal Pn=n(3n−1)/2 1, 5, 12, 22, 35, ...
 * Hexagonal Hn=n(2n−1) 1, 6, 15, 28, 45, ...
 * It can be verified that T285 = P165 = H143 = 40755.
 *
 * Find the next triangle number that is also pentagonal and hexagonal.
 */
public class Problem0045 {

  public static void main(String[] args) {
    Utils.time(Problem0045::first_try);
  }

  public static void first_try() {

    long t = -2, p = -1, h = 0;
    long tn = 285 + 1, pn = 165 + 1, hn = 143 + 1;
    while (t != p && p != h) {

      System.out.println(tn + ":" + t + "," + pn + ":" + p + "," + hn + ":" + h);

      h = hn * (2 * hn - 1);
      hn++;

      while (p < h) {
        p = pn * (3 * pn - 1) / 2;
        pn++;
      }

      while (t < h) {
        t = tn * (tn + 1) / 2;
        tn++;
      }

    }

    System.out.println(tn + ":" + t + "," + pn + ":" + p + "," + hn + ":" + h);

  }

}
