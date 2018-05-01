package net.projecteuler.level002;

import net.projecteuler.utils.Utils;

/*
 * Starting with the number 1 and moving to the right in a clockwise direction a 5 by 5 spiral is
 * formed as follows:
 *
 * 21 22 23 24 25
 * 20 07 08 09 10
 * 19 06 01 02 11
 * 18 05 04 03 12
 * 17 16 15 14 13
 *
 * It can be verified that the sum of the numbers on the diagonals is 101.
 *
 * What is the sum of the numbers on the diagonals in a 1001 by 1001 spiral formed in the same way?
 */
public class Problem0028 {

  public static void main(String[] args) {

    Utils.time(Problem0028::first_try);

  }

  // 08:25 ~ 08:54 : 29 min
  public static void first_try() {

    int limit = 1001;

    int[][] grid = new int[limit][limit];

    int x = limit / 2, y = x;
    grid[y][x] = 1;
    int status = 0;
    for (int i = 2; i <= limit * limit; i++) {
      switch (status) {
        case 0:
          x++;
          grid[y][x] = i;
          if (grid[y + 1][x] == 0) {
            status = 1;
          }
          break;
        case 1:
          y++;
          grid[y][x] = i;
          if (grid[y][x - 1] == 0) {
            status = 2;
          }
          break;
        case 2:
          x--;
          grid[y][x] = i;
          if (grid[y - 1][x] == 0) {
            status = 3;
          }
          break;
        case 3:
          y--;
          grid[y][x] = i;
          if (grid[y][x + 1] == 0) {
            status = 0;
          }
          break;

        default:
          break;
      }
    }

    // Utils.print_grid(grid);

    int sum = -1;
    for (int i = 0; i < limit; i++) {
      sum = sum + grid[i][i] + grid[i][limit - 1 - i];
//      System.out.println(grid[i][i] + ", " + grid[i][limit - 1 - i]);
    }

    System.out.println(sum);

    /*
     * 0,0 1,1 2,2
     * 0,4, 1,3
     * 21 22 23 24 25
     * 20 7 8 9 10
     * 19 6 1 2 11
     * 18 5 4 3 12
     * 17 16 15 14 13
     */
  }

}
