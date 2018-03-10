package net.projecteuler;

/*
 * If the numbers 1 to 5 are written out in words: one, two, three, four, five, then there are 3 + 3
 * + 5 + 4 + 4 = 19 letters used in total.
 *
 * If all the numbers from 1 to 1000 (one thousand) inclusive were written out in words, how many
 * letters would be used?
 *
 *
 * NOTE: Do not count spaces or hyphens. For example, 342 (three hundred and forty-two) contains 23
 * letters and 115 (one hundred and fifteen) contains 20 letters. The use of "and" when writing out
 * numbers is in compliance with British usage.
 */
public class Problem0017 {

  public static void main(String[] args) {
    /*
     * one two three four five six seven eight nine
     * ten eleven twelve thirteen fourteen fifteen sixteen seventeen eighteen nineteen
     * twenty thirty forty fifty sixty seventy eighty ninety
     * one hundred one thousand
     */

    int[] lengths = new int[1001];

    lengths[1] = "one".length();
    lengths[2] = "two".length();
    lengths[3] = "three".length();
    lengths[4] = "four".length();
    lengths[5] = "five".length();
    lengths[6] = "six".length();
    lengths[7] = "seven".length();
    lengths[8] = "eight".length();
    lengths[9] = "nine".length();
    lengths[10] = "ten".length();
    lengths[11] = "eleven".length();
    lengths[12] = "twelve".length();
    lengths[13] = "thirteen".length();
    lengths[14] = "fourteen".length();
    lengths[15] = "fifteen".length();
    lengths[16] = "sixteen".length();
    lengths[17] = "seventeen".length();
    lengths[18] = "eighteen".length();
    lengths[19] = "nineteen".length();
    lengths[20] = "twenty".length();
    lengths[30] = "thirty".length();
    lengths[40] = "forty".length();
    lengths[50] = "fifty".length();
    lengths[60] = "sixty".length();
    lengths[70] = "seventy".length();
    lengths[80] = "eighty".length();
    lengths[90] = "ninety".length();
    lengths[100] = "onehundred".length();
    lengths[1000] = "onethousand".length();

    int sum = 0;
    for (int i = 1; i < 1000; i++) {

      int len = lengths[i];

      if (len == 0) {
        int index = 0;

        int n = i;

        // TODO handle cases,

      }

      if (len == 0) {
        System.out.println("can't cover : " + i);
        break;
      }

      sum += len;

    }

    System.out.println(sum);

  }

}
