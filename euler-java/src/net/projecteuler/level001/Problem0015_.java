package net.projecteuler.level001;

import net.projecteuler.utils.Utils;

/*
 * Starting in the top left corner of a 2×2 grid, and only being able to move to the right and down,
 * there are exactly 6 routes to the bottom right corner.
 *
 *
 * How many such routes are there through a 20×20 grid?
 */
public class Problem0015_ {

  public static void main(String[] args) {

    Utils.time(Problem0015_::pascals_triangle);
  }

  public static void pascals_triangle() {
    int n = 21, m = 21;

    long[][] grid = new long[n][m];

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (i == 0 || j == 0) {
          grid[i][j] = 1;
        } else {
          grid[i][j] = grid[i - 1][j] + grid[i][j - 1];
        }

      }
    }

    System.out.println(grid[n - 1][m - 1]);
    // Utils.print_grid(grid);
  }

}
