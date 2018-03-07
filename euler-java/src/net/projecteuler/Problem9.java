package net.projecteuler;

/*
 * A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
 *
 * a^2 + b^2 = c^2
 * For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2.
 *
 * There exists exactly one Pythagorean triplet for which a + b + c = 1000.
 * Find the product abc.
 */
public class Problem9 {

  public static void main(String[] args) {

    for (int c = 1000; c > 1; c--) {
      int ab = 1000 - c;
      for (int b = ab; b > 1; b--) {
        int a = ab - b;

        if (a < b && b < c) {
          if (a * a + b * b == c * c) {
            System.out.println(a + "," + b + "," + c);
            System.out.println(a * b * c);
          }
        }
      }
    }

  }

}
