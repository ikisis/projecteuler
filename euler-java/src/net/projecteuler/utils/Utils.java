package net.projecteuler.utils;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Utils {

  private static final BigInteger TWO = BigInteger.valueOf(2);

  public static BigInteger sqrt(BigInteger n) {
    if (n.signum() >= 0) {
      final int bitLength = n.bitLength();
      BigInteger root = BigInteger.ONE.shiftLeft(bitLength / 2);

      while (!isSqrt(n, root)) {
        root = root.add(n.divide(root)).divide(TWO);
      }
      return root;
    } else {
      throw new ArithmeticException("square root of negative number");
    }
  }

  private static boolean isSqrt(BigInteger n, BigInteger root) {
    final BigInteger lowerBound = root.pow(2);
    final BigInteger upperBound = root.add(BigInteger.ONE).pow(2);
    return lowerBound.compareTo(n) <= 0
        && n.compareTo(upperBound) < 0;
  }

  public static boolean isSquare(int n) {

    int i = n / 2;
    for (; i * i > n; i--) {}

    return i * i == n;

  }

  public static boolean isSquare(BigInteger n) {

    return sqrt(n).pow(2).equals(n);

  }

  public static int sum(int[] seq) {
    int sum = 0;
    for (int i = 0; i < seq.length; i++) {
      sum += seq[i];
    }
    return sum;
  }

  public static void print_seq(int[] seq) {
    for (int i = 0; i < seq.length; i++) {

      System.out.print(seq[i] + ",");

    }
    System.out.println();
  }

  public static void print_seq(long[] seq) {
    for (int i = 0; i < seq.length; i++) {

      System.out.print(seq[i] + ",");

    }
    System.out.println();
  }

  public static void print_seq_to_num(int[] seq) {
    boolean flag = false;
    for (int i = 0; i < seq.length; i++) {

      if (!flag && seq[i] > 0) {
        flag = true;
      }

      if (flag == true) {
        System.out.print(seq[i]);
      }

    }
    System.out.println();
  }

  public static void print_grid(long[][] grid) {
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        System.out.print(grid[i][j] + " ");
      }
      System.out.println();
    }
  }

  public static void print_grid(int[][] grid) {
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {

        System.out.print(String.format("%2s ", grid[i][j]));
      }
      System.out.println();
    }
  }

  public static void slow(long term) {

    try {
      Thread.sleep(term);
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  public static long time(Runnable runnable) {

    long startTime = System.currentTimeMillis();

    runnable.run();

    long endTime = System.currentTimeMillis();

    long lap = endTime - startTime;

    System.out.println((lap) + "ms elapsed");

    return lap;

  }

  public static void time(Runnable runnable1, Runnable runnable2) {
    long lap1 = time(runnable1);
    long lap2 = time(runnable2);

    System.out.println("A : " + lap1 + "ms elapsed");
    System.out.println("B : " + lap2 + "ms elapsed");

    System.out.print(
        (lap1 >= lap2 ? "B" : "A") + " reduced time "
            + (lap1 > 0 ? ((lap1 - lap2) * 100 / lap1) : lap2)
            + "% than " + (lap1 <= lap2 ? "B" : "A"));

  }

  public static int gcd(int... nums) {

    int max = 0;

    for (int i = 0; i < nums.length; i++) {
      if (max < nums[i]) {
        max = nums[i];
      }
    }
    int gcd = 0;
    for (int i = 2; i < max; i++) {
      boolean flag = true;
      for (int j = 0; j < nums.length; j++) {
        if (nums[j] % i != 0) {
          flag = false;
          break;
        }
      }

      if (flag) {
        gcd = i;

      }
    }

    return gcd;

  }

  public static int reversePrimeFactorization(int[] primes) {

    int res = 1;
    for (int i = 0; i < primes.length; i++) {
      if (primes[i] > 0) {
        int n = 1;
        for (int j = 0; j < primes[i]; j++) {
          n = n * i;
        }

        res = res * n;
      }
    }

    return res;
  }

  public static int[] doPrimeFactorization(int n) {

    int[] primes = new int[n + 1];

    int acc = n;

    for (int i = 2; i <= acc;) {
      if (acc % i == 0) {
        acc = acc / i;
        primes[i] = primes[i] + 1;
      } else {
        i++;
      }
    }

    return primes;
  }

  public static Map<BigInteger, Integer> doPrimeFactorization(BigInteger n) {

    Map<BigInteger, Integer> primes = new HashMap<>();

    BigInteger acc = n;

    for (BigInteger i = BigInteger.valueOf(2); i.compareTo(acc) < 1;) {
      if (acc.mod(i).equals(BigInteger.ZERO)) {
        acc = acc.divide(i);

        if (primes.containsKey(i)) {
          primes.put(i, primes.get(i) + 1);
        } else {
          primes.put(i, 1);
        }

      } else {
        i = i.add(BigInteger.ONE);
      }
    }

    return primes;
  }

  public static boolean isPrime(int n) {
    if (n == 0) {
      return false;
    }

    if (n == 1) {
      return false;
    }

    if (n == 2) {
      return true;
    }

    boolean flag = true;

    for (int i = 2; i * i <= n; i++) {
      if (n % i == 0) {
        flag = false;
        break;
      }

    }
    return flag;
  }

  public static boolean isPrime(long n) {
    if (n == 0) {
      return false;
    }

    if (n == 1) {
      return false;
    }

    if (n == 2) {
      return true;
    }

    boolean flag = true;

    for (int i = 2; i * i <= n; i++) {
      if (n % i == 0) {
        flag = false;
        break;
      }

    }
    return flag;
  }

  public static boolean[] primes(int n) {

    boolean[] primes = new boolean[n + 1];

    for (int i = 0; i <= n; i++) {

      primes[i] = isPrime(i);

    }

    return primes;
  }

  public static boolean[] primes_sieve(int n) {

    boolean[] primes = new boolean[n + 1];

    Arrays.fill(primes, true);

    primes[1] = isPrime(1);

    for (int i = 2; i <= n; i++) {

      if (primes[i]) {
        if (isPrime(i)) {
          int iter = i + i;
          while (iter <= n) {
            primes[iter] = false;
            iter += i;
          }
        }
      }

    }

    return primes;

  }

  public static void prime_factorization_print(int[] primes) {
    boolean flag = true;
    for (int i = 0; i < primes.length; i++) {

      if (primes[i] != 0) {
        if (flag) {
          flag = false;
        } else {
          System.out.print(" x ");

        }
        System.out.print(i);
        if (primes[i] > 1) {
          System.out.print("^" + primes[i]);
        }
      }
    }
    System.out.println();
  }

  public static void prime_factorization_print(Map<BigInteger, Integer> primes) {

    for (Entry<BigInteger, Integer> e : primes.entrySet()) {

      System.out.print(e.getKey() + "^" + e.getValue() + " ");
    }

    System.out.println();

  }
}
