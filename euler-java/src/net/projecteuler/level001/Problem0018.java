package net.projecteuler.level001;

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
 * Find the maximum total from top to bottom of the triangle below:
 *
 * 75
 * 95 64
 * 17 47 82
 * 18 35 87 10
 * 20 04 82 47 65
 * 19 01 23 75 03 34
 * 88 02 77 73 07 63 67
 * 99 65 04 28 06 16 70 92
 * 41 41 26 56 83 40 80 70 33
 * 41 48 72 33 47 32 37 16 94 29
 * 53 71 44 65 25 43 91 52 97 51 14
 * 70 11 33 28 77 73 17 78 39 68 17 57
 * 91 71 52 38 17 14 91 43 58 50 27 29 48
 * 63 66 04 68 89 53 67 30 73 16 69 87 40 31
 * 04 62 98 27 23 09 70 98 73 93 38 53 60 04 23
 *
 * NOTE: As there are only 16384 routes, it is possible to solve this problem by trying every route.
 * However, Problem 67, is the same challenge with a triangle containing one-hundred rows; it cannot
 * be solved by brute force, and requires a clever method! ;o)
 */
public class Problem0018 {

  public static void main(String[] args) {

    Utils.stopwatch(Problem0018::brute_force);

    // TODO solve NOTE

  }

  public static void brute_force() {

    int[][] triangle = triangle();

    print_triagle(triangle);

    System.out.println(">>" + traverse(triangle, 0, 0, 0));

  }

  private static int traverse(int[][] triangle, int depth, int index, int sum) {

    if (depth >= triangle.length) {
      return sum;
    }

    sum = sum + triangle[depth][index];

    depth++;

    int left = traverse(triangle, depth, index, sum);

    int right = traverse(triangle, depth, index + 1, sum);

    return left > right ? left : right;

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

    String tString = "75 " +
        "95 64 " +
        "17 47 82 " +
        "18 35 87 10 " +
        "20 04 82 47 65 " +
        "19 01 23 75 03 34 " +
        "88 02 77 73 07 63 67 " +
        "99 65 04 28 06 16 70 92 " +
        "41 41 26 56 83 40 80 70 33 " +
        "41 48 72 33 47 32 37 16 94 29 " +
        "53 71 44 65 25 43 91 52 97 51 14 " +
        "70 11 33 28 77 73 17 78 39 68 17 57 " +
        "91 71 52 38 17 14 91 43 58 50 27 29 48 " +
        "63 66 04 68 89 53 67 30 73 16 69 87 40 31 " +
        "04 62 98 27 23 09 70 98 73 93 38 53 60 04 23";

    String[] tokens = tString.split("[ ]");

    int[] seq = new int[tokens.length];

    for (int i = 0; i < tokens.length; i++) {
      seq[i] = Integer.parseInt(tokens[i]);
    }

    int[][] triangle = new int[15][15];

    int zero = 0;
    for (int depth = 0; zero + depth < seq.length; depth++) {

      zero = zero + depth;

      for (int i = 0; i <= depth; i++) {
        triangle[depth][i] = seq[zero + i];
      }

    }
    return triangle;
  }

}
