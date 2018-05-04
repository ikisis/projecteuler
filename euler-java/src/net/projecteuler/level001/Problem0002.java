package net.projecteuler.level001;

import net.projecteuler.utils.Utils;

/*
 * Each new term in the Fibonacci sequence is generated by adding the previous two terms. By
 * starting with 1 and 2, the first 10 terms will be:
 *
 * 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
 *
 * By considering the terms in the Fibonacci sequence whose values do not exceed four million, find
 * the sum of the even-valued terms.
 */
public class Problem0002 {

  public static void main(String[] args) {

    Utils.time(Problem0002::solution);

  }

  public static void solution() {

    int a = 1, b = 2, c = 3;

    int sum = 0;

    while (b < 4000000) {
      sum += b;
      a = b + c;
      b = c + a;
      c = a + b;
    }

    System.out.println(sum);

  }

}
