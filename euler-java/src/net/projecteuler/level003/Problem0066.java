package net.projecteuler.level003;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import net.projecteuler.utils.Fraction;
import net.projecteuler.utils.Utils;

/*
 * Consider quadratic Diophantine equations of the form:
 *
 * x^2 – Dy^2 = 1
 *
 * For example, when D=13, the minimal solution in x is 649^2 – 13×180^2 = 1.
 *
 * It can be assumed that there are no solutions in positive integers when D is square.
 *
 * By finding minimal solutions in x for D = {2, 3, 5, 6, 7}, we obtain the following:
 *
 * 3^2 – 2×2^2 = 1
 * 2^2 – 3×1^2 = 1
 * 9^2 – 5×4^2 = 1
 * 5^2 – 6×2^2 = 1
 * 8^2 – 7×3^2 = 1
 *
 * Hence, by considering minimal solutions in x for D ≤ 7, the largest x is obtained when D=5.
 *
 * Find the value of D ≤ 1000 in minimal solutions of x for which the largest value of x is
 * obtained.
 */
public class Problem0066 {

  public static void main(String[] args) {

    Utils.time(Problem0066::first_try);

  }

  public static void first_try() {

    BigInteger max_x = BigInteger.ZERO;

    int result_d = 0;

    for (int d = 2; d <= 1000; d++) {

      BigInteger D = BigInteger.valueOf(d);

      if (Utils.isSquare(d)) {
        continue;
      }

      int a1 = 0, a = 0, b = 0, c = 0;

      a1 = (int) Math.sqrt(d);

      a = a1;

      b = 1;

      c = a1;

      List<Integer> as = new ArrayList<>();

      as.add(a);

      for (;;) {

        Fraction f = new Fraction(as.get(as.size() - 1));

        for (int i = as.size() - 2; i >= 0; i--) {

          f = new Fraction(as.get(i)).add(f.inverse());

        }

        // System.out.println(as + " >> " + f);

        if (f.getN().pow(2).subtract(f.getD().pow(2).multiply(D)).equals(BigInteger.ONE)) {

          System.out.println(d + " > " + f);

          if (max_x.compareTo(f.getN()) == -1) {
            max_x = f.getN();
            result_d = d;
          }

          break;

        }

        b = ((d - (c * c)) / b);

        a = (a1 + c) / b;

        c = (c - (a * b)) * -1;

        as.add(a);

      }

    }

    System.out.println(result_d + " > " + max_x);

  }

}
