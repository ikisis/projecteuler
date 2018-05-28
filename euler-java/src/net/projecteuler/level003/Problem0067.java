package net.projecteuler.level003;

import java.io.IOException;
import java.io.InputStream;

import net.projecteuler.utils.Utils;

/*
 * By starting at the top of the triangle below and moving to adjacent numbers on the row below, the
 * maximum total from top to bottom is 23.
 *
 * 3
 * 7 4
 * 2 4 6
 * 8 5 9 3
 *
 * That is, 3 + 7 + 4 + 9 = 23.
 *
 * Find the maximum total from top to bottom in triangle.txt (right click and 'Save Link/Target
 * As...'), a 15K text file containing a triangle with one-hundred rows.
 *
 * NOTE: This is a much more difficult version of Problem 18. It is not possible to try every route
 * to solve this problem, as there are 299 altogether! If you could check one trillion (1012) routes
 * every second it would take over twenty billion years to check them all. There is an efficient
 * algorithm to solve it. ;o)
 */
public class Problem0067 {

  public static void main(String[] args) {

    // Utils.time(Problem0067::brute_force);

    Utils.time(Problem0067::solution);

    // TODO solve NOTE

  }

  public static void solution() {

    int[][] triangle = triangle();

    int[][] sum_triangle = new int[triangle.length][triangle[0].length];

    int max = 0;

    for (int i = 0; i < triangle.length; i++) {
      for (int j = 0; j < triangle[i].length; j++) {

        if (i == 0) {
          sum_triangle[i][j] = triangle[i][j];
          continue;
        }

        int left = j > 0 ? sum_triangle[i - 1][j - 1] : 0;

        int right = sum_triangle[i - 1][j];

        sum_triangle[i][j] = triangle[i][j] + (left > right ? left : right);

        if (sum_triangle[i][j] > max) {
          max = sum_triangle[i][j];
        }

      }

    }

    System.out.println(max);

  }

  private static void print_triagle(int[][] triangle) {
    int zero = 0;
    for (int depth = 0; depth < triangle.length; depth++) {

      zero = zero + depth;

      for (int i = 0; i < triangle[depth].length; i++) {
        System.out.print(String.format(" %2s", triangle[depth][i]));
      }

      System.out.println();

    }
  }

  public static int[][] triangle() {

    String tString = loadString();

    String[] tokens = tString.split("[ ]");

    int[] seq = new int[tokens.length];

    for (int i = 0; i < tokens.length; i++) {
      seq[i] = Integer.parseInt(tokens[i]);
    }

    int[][] triangle = new int[100][100];

    int zero = 0;
    for (int depth = 0; zero + depth < seq.length; depth++) {

      zero = zero + depth;

      for (int i = 0; i <= depth; i++) {
        triangle[depth][i] = seq[zero + i];
      }

    }
    return triangle;
  }

  public static String loadString() {

    InputStream is = Problem0067.class.getClassLoader()
        .getResourceAsStream("net/projecteuler/res/p067_triangle.txt");

    int i = 0;
    StringBuilder sb = new StringBuilder();
    try {
      while ((i = is.read()) != -1) {
        sb.append((char) i);
      }
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    String s = sb.toString().replaceAll("[\n]", " ");

    return s;

  }

}
