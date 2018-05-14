package net.projecteuler.level003;

import java.util.HashSet;

import net.projecteuler.utils.Utils;

/*
 * How many continued fractions for N ≤ 10000 have an odd period?
 */
public class Problem0064 {

  public static void main(String[] args) {

    Utils.time(Problem0064::first_try);

  }

  public static void first_try() {

    int count = 0;

    for (int n = 2; n <= 10000; n++) {

      int a1 = 0, a = 0, b = 0, c = 0;

      int i = 1;
      for (; i * i < n; i++) {

      }

      a1 = i - 1;

      a = a1;

      b = 1;

      c = a1;

      HashSet<String> periods = new HashSet<>();

      for (;;) {

        b = ((n - (c * c)) / b);

        a = (a1 + c) / b;

        c = (c - (a * b)) * -1;

        String abc = a + ":" + b + ":" + c;

        if (periods.contains(abc)) {

          if (periods.size() % 2 != 0) {
            count++;
          }

          break;
        } else {
          periods.add(abc);
        }

      }
    }

    System.out.println(count);

  }

}
