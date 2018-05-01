package net.projecteuler.level003;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

import net.projecteuler.utils.Utils;

/*
 * The 5-digit number, 16807=7^5, is also a fifth power. Similarly, the 9-digit number,
 * 134217728=8^9,
 * is a ninth power.
 *
 * How many n-digit positive integers exist which are also an nth power?
 */
public class Problem0063 {

  public static void main(String[] args) {

    Utils.time(Problem0063::first_try);

  }

  public static void first_try() {

    Set<BigInteger> set = new HashSet<>();

    for (int i = 2; i < 100; i++) {

      for (int j = 1; j < 100; j++) {
        BigInteger n = new BigInteger("" + i).pow(j);

        if (n.toString().length() == j) {
          set.add(n);
        }

      }

    }

    System.out.println(set.size() + 1);

  }

}
