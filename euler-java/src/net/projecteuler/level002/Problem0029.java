package net.projecteuler.level002;

import java.util.HashSet;
import java.util.Set;

import net.projecteuler.utils.Utils;

/*
 * Consider all integer combinations of a^b for 2 ≤ a ≤ 5 and 2 ≤ b ≤ 5:
 *
 * 2^2=4, 2^3=8, 2^4=16, 2^5=32
 * 3^2=9, 3^3=27, 3^4=81, 3^5=243
 * 4^2=16, 4^3=64, 4^4=256, 4^5=1024
 * 5^2=25, 5^3=125, 5^4=625, 5^5=3125
 * If they are then placed in numerical order, with any repeats removed, we get the following
 * sequence of 15 distinct terms:
 *
 * 4, 8, 9, 16, 25, 27, 32, 64, 81, 125, 243, 256, 625, 1024, 3125
 *
 * How many distinct terms are in the sequence generated by ab for 2 ≤ a ≤ 100 and 2 ≤ b ≤ 100?
 */
public class Problem0029 {

  public static void main(String[] args) {

    Utils.time(Problem0029::first_try);

  }

  public static void first_try() {

    int limit = 100;

    int count = 0;

    Set<String> factorizations = new HashSet<>();

    for (int a = 2; a <= limit; a++) {
      for (int b = 2; b <= limit; b++) {
        int[] f = Utils.doPrimeFactorization(a);

        String fs = "";
        for (int i = 0; i < f.length; i++) {
          if (f[i] > 0) {
            fs = fs + i + "^" + (f[i] * b);
          }
        }

        if (!factorizations.contains(fs)) {
          factorizations.add(fs);
          count++;
          System.out.println(fs);
        }

      }
    }

    System.out.println(count);

  }

}
