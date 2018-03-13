package net.projecteuler;

import net.projecteuler.utils.Utils;

/*
 * A permutation is an ordered arrangement of objects. For example, 3124 is one possible permutation
 * of the digits 1, 2, 3 and 4. If all of the permutations are listed numerically or alphabetically,
 * we call it lexicographic order. The lexicographic permutations of 0, 1 and 2 are:
 *
 * 012 021 102 120 201 210
 *
 * What is the millionth lexicographic permutation of the digits 0, 1, 2, 3, 4, 5, 6, 7, 8 and 9?
 */
public class Problem0024_ {

  public static void main(String[] args) {

    // TODO solve by using euler's
    Utils.stopwatch(Problem0024_::first_try);

  }

  /*
   * 012
   * 021
   * 102
   * 120
   * 201
   * 210
   *
   *
   * 0, 1, 2, 3, 4, 5, 6, 7, 8, 9
   * 0, 1, 2, 3, 4, 5, 6, 7, 9, 8
   * 0, 1, 2, 3, 4, 5, 6, 8, 7, 9
   * 0, 1, 2, 3, 4, 5, 6, 8, 9, 7
   * 0, 1, 2, 3, 4, 5, 6, 9, 7, 8
   * 0, 1, 2, 3, 4, 5, 6, 9, 8, 7
   *
   * 0, 1, 2, 3, 4, 5, 7, 6, 8, 9
   * 0, 1, 2, 3, 4, 5, 7, 6, 9, 8
   * 0, 1, 2, 3, 4, 5, 7, 8, 6, 9
   * 0, 1, 2, 3, 4, 5, 7, 8, 9, 6
   * 0, 1, 2, 3, 4, 5, 7, 9, 6, 8
   * 0, 1, 2, 3, 4, 5, 7, 9, 8, 6
   */
  public static void first_try() {
    int[] seq = new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
    int count = 1;
    int numPerm = 1000000;

    while (count < numPerm) {
      int N = seq.length;
      int i = N - 1;

      while (seq[i - 1] >= seq[i]) {
        i = i - 1;
      }

      int j = N;
      while (seq[j - 1] <= seq[i - 1]) {
        j = j - 1;
      }

      swap(seq, i - 1, j - 1);

      i++;
      j = N;

      while (i < j) {
        swap(seq, i - 1, j - 1);
        i++;
        j--;
      }
      count++;
    }

    String permNum = "";
    for (int k = 0; k < seq.length; k++) {
      permNum = permNum + seq[k];
    }

    System.out.println(permNum);
  }

  private static void swap(int[] seq, int i, int j) {
    int k = seq[i];
    seq[i] = seq[j];
    seq[j] = k;
  }

}
