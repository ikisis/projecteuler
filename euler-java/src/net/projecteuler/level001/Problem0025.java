package net.projecteuler.level001;

import net.projecteuler.utils.Utils;

/*
 * The Fibonacci sequence is defined by the recurrence relation:
 *
 * Fn = Fn−1 + Fn−2, where F1 = 1 and F2 = 1.
 * Hence the first 12 terms will be:
 *
 * F1 = 1
 * F2 = 1
 * F3 = 2
 * F4 = 3
 * F5 = 5
 * F6 = 8
 * F7 = 13
 * F8 = 21
 * F9 = 34
 * F10 = 55
 * F11 = 89
 * F12 = 144
 * The 12th term, F12, is the first term to contain three digits.
 *
 * What is the index of the first term in the Fibonacci sequence to contain 1000 digits?
 */
public class Problem0025 {

  public static void main(String[] args) {

    Utils.stopwatch(Problem0025::first_try);

  }

  public static void first_try() {

    int index = 2;

    int limit = 1000;

    int[] a = new int[limit], b = new int[limit];
    a[a.length - 1] = 1;
    b[b.length - 1] = 1;

    int over = 0;

    while (over == 0) {
      over = 0;
      // int[] sum = new int[limit];
      for (int i = a.length - 1; i > 0; i--) {
        a[i] = a[i] + b[i] + over;
        over = a[i] / 10;
        if (over > 0) {
          a[i] = a[i] % 10;
        }
      }

      int[] tmp = a;
      a = b;
      b = tmp;
      index++;

    }
    System.out.println(index);
  }

}
