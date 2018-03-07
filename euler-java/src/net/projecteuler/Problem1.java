package net.projecteuler;

/*
 * If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9.
 * The sum of these multiples is 23.
 *
 * Find the sum of all the multiples of 3 or 5 below 1000.
 */
public class Problem1 {

  public static void main(String[] args) {

    brute_force();

    boolean[] checked = new boolean[1001];

    int a = 3, b = 5, sum = 0;

    while (a < 1000) {
      if (!checked[a]) {
        checked[a] = true;
        sum += a;
      }
      a += 3;

      if (b < 1000) {
        if (!checked[b]) {
          checked[b] = true;
          sum += b;
        }
        b += 5;
      }

    }

    System.out.println(sum);

  }

  public static void brute_force() {

    int sum = 0;

    for (int i = 1; i < 1000; i++) {
      if (i % 3 == 0 || i % 5 == 0) {
        sum += i;
      }
    }

    System.out.println(sum);

  }

}
