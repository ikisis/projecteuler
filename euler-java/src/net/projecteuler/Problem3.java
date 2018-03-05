package net.projecteuler;

/*
 * The prime factors of 13195 are 5, 7, 13 and 29.
 *
 * What is the largest prime factor of the number 600851475143 ?
 */
public class Problem3 {

  public static void main(String[] args) {

    long a = 600851475143L, b = 5;

    for (; b < a; b = b + 2) {

      if (a % b == 0) {

        a = a / b;

        b = 5;

      }

    }

    System.out.println(b);

  }

}
