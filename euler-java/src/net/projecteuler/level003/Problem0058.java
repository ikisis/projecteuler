package net.projecteuler.level003;

import net.projecteuler.utils.Utils;

/*
 * Starting with 1 and spiralling anticlockwise in the following way, a square spiral with side
 * length 7 is formed.
 *
 * 37 36 35 34 33 32 31
 * 38 17 16 15 14 13 30
 * 39 18 05 04 03 12 29
 * 40 19 06 01 02 11 28
 * 41 20 07 08 09 10 27
 * 42 21 22 23 24 25 26
 * 43 44 45 46 47 48 49
 *
 * It is interesting to note that the odd squares lie along the bottom right diagonal, but what is
 * more interesting is that 8 out of the 13 numbers lying along both diagonals are prime; that is, a
 * ratio of 8/13 ≈ 62%.
 *
 * If one complete new layer is wrapped around the spiral above, a square spiral with side length 9
 * will be formed. If this process is continued, what is the side length of the square spiral for
 * which the ratio of primes along both diagonals first falls below 10%?
 */
public class Problem0058 {

  public static void main(String[] args) {

    Utils.time(Problem0058::first_try);

  }

  public static void first_try() {

    int side_length = 30001;

    int[][] spiral = new int[side_length][side_length];

    int x = side_length / 2, y = x;

    int i = 1;

    int direction = 0;

    double prime = 0;
    double not_prime = 0;

    int curr_len = 1;

    while (x < side_length && y < side_length) {

      if (x == y || x + y == side_length - 1) {
        if (Utils.isPrime(i)) {
          prime++;
        } else {
          not_prime++;
        }

        if (i > 49 && prime / (prime + not_prime) < 0.1d) {
          System.out.println(i);
          break;
        }
      }

      spiral[y][x] = i;
      i++;
      switch (direction) {
        case 0:
          if (i == 2) {
            x++;
          } else if (spiral[y - 1][x] == 0) {
            curr_len += 2;
            direction = 1;
            y--;

          } else {
            x++;

          }

          break;
        case 1:
          if (spiral[y][x - 1] == 0) {
            direction = 2;
            x--;

          } else {
            y--;
          }
          break;
        case 2:
          if (spiral[y + 1][x] == 0) {
            direction = 3;
            y++;

          } else {
            x--;
          }
          break;
        case 3:
          if (spiral[y][x + 1] == 0) {
            direction = 0;
            x++;

          } else {
            y++;
          }
          break;
        default:
          break;
      }

    }

    // Utils.print_grid(spiral);
    System.out.println(curr_len);
    System.out
        .println(prime + "," + (not_prime + prime) + " => " + prime / (not_prime + prime));

  }

}
