package net.projecteuler.level003;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.projecteuler.utils.Utils;

public class Problem0066_DiophantineEquation {

  public static void main(String[] args) {
    Utils.time(Problem0066_DiophantineEquation::fisrt_try);

  }

  public static void fisrt_try() {

//    HashSet<BigInteger> squareSet = new HashSet<>();
//
//    for (long i = 1; i < 4_999_999; i++) {
//      squareSet.add(BigInteger.valueOf(i).pow(2));
//    }

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

}
