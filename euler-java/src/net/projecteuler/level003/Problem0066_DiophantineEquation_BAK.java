package net.projecteuler.level003;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

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
public class Problem0066_DiophantineEquation_BAK {

  public static void main(String[] args) {

//    Utils.time(Problem0066_DiophantineEquation_BAK::fisrt_try);

    // Utils.time(Problem0066_DiophantineEquation_BAK::second_try);

    for (int i = 2; i <= 16; i++) {

//      if (!Utils.isSquare2(BigInteger.valueOf(i))) {
//        System.out.println(i);
//      }
//      if (!Utils.isSquare(i)) {
//        System.out.println(i);
//      }

    }

//    Utils.time(Problem0066_DiophantineEquation::third_try);

    Utils.time(Problem0066_DiophantineEquation_BAK::fourth_try);

  }

  public static void fifth_try() {

    int max_D = 1000, max_x = 0;

    List<Integer> Ds = new ArrayList<>();

    for (int i = 2; i <= max_D; i++) {
      if (!Utils.isSquare(i)) {
        Ds.add(i);
      }
    }

    int max_X = 0;
    for (int x = 2; x < 999999999; x++) {

      BigInteger x_pow = BigInteger.valueOf(x).pow(2);

      BigInteger x_pow_sub_one = x_pow.subtract(BigInteger.ONE);

      for (Iterator<Integer> it = Ds.iterator(); it.hasNext();) {
        int d = it.next();
        final BigInteger D = BigInteger.valueOf(d);

        if (x_pow_sub_one.mod(D).equals(BigInteger.ZERO)) {

          BigInteger y_pow = x_pow_sub_one.divide(D);

          BigInteger y = Utils.sqrt(y_pow);

          if (y.pow(2).equals(y_pow)) {

            System.out.println(x + " : " + " Ds.size() = " + Ds.size() + " D : " + D);

            it.remove();

            continue;

          }
        }

        BigInteger x_pow2 = D.multiply(x_pow).add(BigInteger.ONE);

        BigInteger x2 = Utils.sqrt(x_pow2);

        if (x2.pow(2).equals(x_pow2)) {

          System.out.println(x + " : " + " Ds.size() = " + Ds.size() + " D : " + D);

          int nx = x2.intValue();

          if (max_X < nx) {
            max_X = nx;
          }

          if (Ds.size() < 400 && x < max_X) {
            x = max_X + 1;
          }

          it.remove();

        }

      }
    }

    System.out.println("result : " + max_x);

  }

  public static void fourth_try() {

    int max_D = 1000;

    BigInteger max_X = BigInteger.ZERO;

    int result_D = 0;

    List<Integer> Ds = new ArrayList<>();

    for (int i = 2; i <= max_D; i++) {
      if (!Utils.isSquare(i)) {
        Ds.add(i);
      }
    }

    for (int y = 1; Ds.size() > 0; y++) {

      BigInteger y_squared = BigInteger.valueOf(y).pow(2);

      for (Iterator<Integer> it = Ds.iterator(); it.hasNext();) {

        BigInteger D = BigInteger.valueOf(it.next());

        BigInteger x_pow = D.multiply(y_squared).add(BigInteger.ONE);

        if (Utils.isSquare(x_pow)) {

          System.out.println(x_pow);

          it.remove();

        }

      }

    }

    System.out.println(result_D);

  }

  public static void third_try() {

    HashSet<BigInteger> squareSet = new HashSet<>();

    for (long i = 1; i < 4_999_999; i++) {
      squareSet.add(BigInteger.valueOf(i).pow(2));
    }

    int max_D = 1000;

    List<Integer> Ds = new ArrayList<>();

    for (int i = 2; i <= max_D; i++) {
      if (!Utils.isSquare(i)) {
        Ds.add(i);
      }
    }

    for (int x = 9_999_999; x > 2; x--) {
      for (int i = 0; i < Ds.size(); i++) {

        BigInteger D = BigInteger.valueOf(Ds.get(i));

        BigInteger x_pow = BigInteger.valueOf(x).pow(2);

        if (x_pow.subtract(BigInteger.ONE).mod(D)
            .compareTo(BigInteger.ZERO) == 0) {

          BigInteger y = x_pow.subtract(BigInteger.ONE).divide(D);

//          if (Utils.isSquare(y)) {
          if (squareSet.contains(y)) {

            System.out.println(D + "," + x + "," + y);
//            Utils.slow(100);

          }

        }

      }
    }

    System.out.println(Ds.size());

  }

  public static void second_try() {
    int max_iter = 100000;
    BigInteger[] squares = new BigInteger[max_iter + 1];

    for (int i = 1; i < squares.length; i++) {
      squares[i] = BigInteger.valueOf(i).pow(2);
      // System.out.println(i + "^2 " + " = " + squares[i]);
    }

    int success_count = 0;

    int square_count = 0;

    for (int d = 2; d <= 1000; d++) {

      if (Utils.isSquare(d)) {
        continue;
      }

      square_count++;

      System.out.print(d + " => ");

      BigInteger D = BigInteger.valueOf(d);

      int max_x = 0;

      int min_x = 2;

      int inc = 100000;

      max_x += inc;

      for (int x = min_x, comp = -1; x < max_x && comp != 0; x++) {

        int y_left = 1, y_right = x;

        BigInteger r = BigInteger.ZERO;

        for (;;) {

          int y = y_left + ((y_right - y_left) / 2);

          r = squares[x].subtract((squares[y].multiply(D)));

          // ( - )

          comp = r.compareTo(BigInteger.ONE);

          if (comp == 0) {
            System.out.println(x + "^2 - " + D + " x " + y + "^2 = " + r);
            // System.out.println("<" + y_left + "," + y_right + ">");

            success_count++;
            break;

          }

          if (y_right - y_left == 1) {
            break;
          }

          if (comp == -1) {
            y_right = y_right - (y_right - y_left) / 2;
          } else if (comp == 1) {
            y_left = y_left + (y_right - y_left) / 2;
          }

          if (y >= x || y == 1) {
            break;
          }

//        Utils.slow(100);

        }

      }
      System.out.println();
    }

    System.out.println(success_count + "/" + square_count);

  }

  public static void fisrt_try() {

    int max_D = 1000, max_iter = 9999, max_x = 0;

    List<Integer> Ds = new ArrayList<>();

    for (int i = 2; i <= max_D; i++) {
      if (!Utils.isSquare(i)) {
        Ds.add(i);
      }
    }

    int[] squares = new int[max_iter + 1];

    for (int i = 1; i < squares.length; i++) {
      squares[i] = i * i;
      // System.out.println(i + "^2 " + " = " + squares[i]);
    }

    for (int x = 2; x < max_iter; x++) {
      for (int y = x - 1; y > 1; y--) {

        for (Iterator<Integer> it = Ds.iterator(); it.hasNext();) {
          int D = it.next();
          if (squares[x] - (D * squares[y]) == 1) {
            System.out.println(x + "^2 - " + D + " x " + x + "^2 = 1, Ds.size : " + Ds.size());

            if (max_x < D) {
              max_x = D;
            }
            it.remove();
            // break;
          }
        }
      }
    }

    System.out.println(Ds.size() + ", " + Ds.get(Ds.size() - 1));

    System.out.println("result : " + max_x);

  }

}
