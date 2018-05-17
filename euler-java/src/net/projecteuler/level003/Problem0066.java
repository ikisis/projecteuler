package net.projecteuler.level003;

import java.math.BigInteger;

import net.projecteuler.utils.Utils;

public class Problem0066 {

  public static void main(String[] args) {

    Utils.time(Problem0066::first_try);

  }

  public static void first_try() {

    int s = 1;

    BigInteger x_pow = BigInteger.valueOf(s).pow(2);

    BigInteger y_pow = x_pow;

  }

}
