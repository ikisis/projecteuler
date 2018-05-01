package net.projecteuler.level002;

import net.projecteuler.utils.Utils;

/*
 * The fraction 49/98 is a curious fraction, as an inexperienced mathematician in attempting to
 * simplify it may incorrectly believe that 49/98 = 4/8, which is correct, is obtained by cancelling
 * the 9s.
 *
 * We shall consider fractions like, 30/50 = 3/5, to be trivial examples.
 *
 * There are exactly four non-trivial examples of this type of fraction, less than one in value, and
 * containing two digits in the numerator and denominator.
 *
 * If the product of these four fractions is given in its lowest common terms, find the value of the
 * denominator.
 */
public class Problem0033 {

  public static void main(String[] args) {

    Utils.time(Problem0033::first_try);

  }

  public static void first_try() {

    int limit = 10;
    int tn = 1;
    int td = 1;
    for (int same = 1; same < limit; same++) {
      for (int n = 1; n < limit; n++) {
        for (int d = 1; d < limit; d++) {

          if (n != d && same != n && same != d) {

            int cn = n;
            int cd = d;

            for (int i = 2; i <= cd; i++) {
              if (cn % i == 0 && cd % i == 0) {
                cn = cn / i;
                cd = cd / i;
                i = 1;
              }
            }
            // System.out.println(">>" + cn + "/" + cd);
            int[] cs = {
                10 * same + n,
                10 * n + same,
                10 * same + d,
                10 * d + same };

            for (int i = 0; i < cs.length / 2; i++) {
              for (int j = 0; j < cs.length / 2; j++) {

                // System.out.println(cs[0 + i] + "/" + cs[2 + j]);

                int rn = cs[0 + i];
                int rd = cs[2 + j];

                if (rn >= rd) {
                  continue;
                }

                for (int k = 2; k <= rd; k++) {
                  if (rn % k == 0 && rd % k == 0) {
                    rn = rn / k;
                    rd = rd / k;
                    k = 1;
                  }
                }

                // System.out.println(">>>>" + rn + "/" + rd);
                if (cn == rn && cd == rd) {
                  System.out.println("%%% : " + cn + "/" + cd);

                  System.out.println("%%%%%%% : " + cs[0 + i] + "/" + cs[2 + j]);

                  tn = tn * cn;
                  td = td * cd;
                }

              }
            }
          }

        }
      }
    }

    for (int i = 2; i <= td; i++) {
      if (tn % i == 0 && td % i == 0) {
        tn = tn / i;
        td = td / i;
        i = 1;
      }
    }
    System.out.println(tn + "/" + td);

  }
}
