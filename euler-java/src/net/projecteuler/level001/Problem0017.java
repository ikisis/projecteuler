package net.projecteuler.level001;

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
    solved1();

    // TODO reduce source length, too complexed
  }

  public static void debugging() {
    /*
     * one two three four five six seven eight nine
     * ten eleven twelve thirteen fourteen fifteen sixteen seventeen eighteen nineteen
     * twenty thirty forty fifty sixty seventy eighty ninety
     * one hundred one thousand
     */

    String[] lengths = new String[1001];
    lengths[0] = "";

    lengths[1] = "one";
    lengths[2] = "two";
    lengths[3] = "three";
    lengths[4] = "four";
    lengths[5] = "five";
    lengths[6] = "six";
    lengths[7] = "seven";
    lengths[8] = "eight";
    lengths[9] = "nine";
    lengths[10] = "ten";
    lengths[11] = "eleven";
    lengths[12] = "twelve";
    lengths[13] = "thirteen";
    lengths[14] = "fourteen";
    lengths[15] = "fifteen";
    lengths[16] = "sixteen";
    lengths[17] = "seventeen";
    lengths[18] = "eighteen";
    lengths[19] = "nineteen";
    lengths[20] = "twenty";
    lengths[30] = "thirty";
    lengths[40] = "forty";
    lengths[50] = "fifty";
    lengths[60] = "sixty";
    lengths[70] = "seventy";
    lengths[80] = "eighty";
    lengths[90] = "ninety";
    lengths[100] = "onehundred";
    lengths[1000] = "onethousand";

    int sum = 0;
    for (int i = 1; i <= 1000; i++) {

      if (lengths[i] == null) {

        String len = "";

        int n = i;

        int p_ten = 1;

        while (n > 0) {

          int r = n % 10;

          len = len + lengths[r * p_ten];

          if (i == 200) {
            System.out.println("200 : " + len + " : " + n);
          }
          n = n / 10;
          p_ten = p_ten * 10;
        }

        if (i == 200) {
          System.out.println("200 : " + len + "$$");
        }
        if ((len == "" || len == null || len.equals("null")) && i % 100 == 0) {
          if (i == 200) {
            System.out.println("200 : " + len + "$$$$");
          }
          len = lengths[i / 100] + "hundred";
        }

        if (i / 100 > 0 && i % 100 > 0) { // and
          len = len + "and";
        }

        lengths[i] = len;

      }
      // 21 : twenty one = 6 + 3 = 9
      // 196 : one hundred and ninety six
      // 201 : two hundred and one
      // 211 : two hundred and eleven = 19
      // 222 : two hundred and twenty two = 19
      // 999 : nine hundred and ninety nine = 24
      if (lengths[i] == null) {
        System.out.println("can't cover : " + i);
        break;
      } else {
        System.out.println(i + ":" + lengths[i]);
      }

      sum += lengths[i].length();
      // 21088
      // 36

    }

    System.out.println(sum);
    System.out.println(21124 - sum);
  }

  public static void solved1() {
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
    for (int i = 1; i <= 1000; i++) {

      if (lengths[i] == 0) {

        int len = 0;

        int n = i;

        int p_ten = 1;

        while (n > 0) {

          if (p_ten == 1 && n > 100 && n % 100 < 20 && n % 100 > 10) {

            int t = n % 100;
            p_ten = p_ten * 100;

            len = len + lengths[t];
            n = n / 100;

          }

          int r = n % 10;

          len = len + lengths[r * p_ten];

          n = n / 10;
          p_ten = p_ten * 10;
        }

        if (len == 0 && i % 100 == 0) {
          len = "hundred".length() + lengths[i / 100];
        }

        if (i / 100 > 0 && i % 100 > 0) { // and
          // System.out.println(i);
          len += 3;
        }

        lengths[i] = len;

      }
      // 21 : twenty one = 6 + 3 = 9
      // 196 : one hundred and ninety six
      // 201 : two hundred and one
      // 211 : two hundred and eleven = 19
      // 222 : two hundred and twenty two = 19
      // 999 : nine hundred and ninety nine = 24
      if (lengths[i] == 0) {
        System.out.println("can't cover : " + i);
        break;
      } else {
        // System.out.println(i + ":" + lengths[i]);
      }

      sum += lengths[i];

    }

    System.out.println(sum);

  }

}
