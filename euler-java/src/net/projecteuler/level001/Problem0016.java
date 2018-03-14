package net.projecteuler.level001;

import java.math.BigInteger;

import net.projecteuler.utils.Utils;

/*
 * 2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.
 *
 * What is the sum of the digits of the number 2^1000?
 */
public class Problem0016 {

  public static void main(String[] args) {

    Utils.stopwatch(Problem0016::use_digit_array);

    Utils.stopwatch(Problem0016::use_big_integer); // better performance

  }

  public static void use_big_integer() {

    BigInteger n = new BigInteger("2").pow(1000);

    int sum = 0;

    String str = n.toString();

    for (int i = 0; i < str.length(); i++) {
      sum += Integer.parseInt("" + str.charAt(i));
    }

    System.out.println(sum);

  }

  public static void use_digit_array() {
    int len = 500; // reduce 1000 to 500

    int[] ans = new int[len];

    ans[len - 1] = 1;

    for (int i = 0; i < 1000; i++) {

      int[] sq = new int[len];
      int ex = 0;
      for (int j = len - 1; j >= 0; j--) {
        int n = ans[j] + ans[j] + ex;

        if (n > 9) {
          ex = 1;
          n = n - 10;
        } else {
          ex = 0;
        }
        sq[j] = n;
      }

      ans = sq;

//      Utils.print_seq_to_num(ans);
//
//      Utils.slowmotion(100);

    }

    int sum = 0;
    for (int i = 0; i < len; i++) {
      sum += ans[i];
    }

    System.out.println(sum);
  }

}
