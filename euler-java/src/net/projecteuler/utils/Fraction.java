package net.projecteuler.utils;

import java.math.BigInteger;

public class Fraction {

  private static BigInteger TWO = BigInteger.valueOf(2);

  private BigInteger n;

  private BigInteger d;

  public Fraction(int n) {
    this(BigInteger.valueOf(n), BigInteger.ONE);
  }

  public Fraction(int n, int d) {
    this(BigInteger.valueOf(n), BigInteger.valueOf(d));
  }

  public Fraction(BigInteger n, BigInteger d) {

//    for (BigInteger i = TWO; i.compareTo(n) < 1 && i.compareTo(d) < 1; i =
//        i.add(BigInteger.ONE)) {
//
//      if (n.mod(i).equals(BigInteger.ZERO) && d.mod(i).equals(BigInteger.ZERO)) {
//        n = n.divide(i);
//        d = d.divide(i);
//      }
//
//    }

    this.n = n;
    this.d = d;
  }

  public Fraction inverse() {
    return new Fraction(d, n);
  }

  public Fraction add(Fraction f) {

    return new Fraction(this.getN().multiply(f.getD()).add(f.getN().multiply(this.getD())),
        this.getD().multiply(f.getD()));

  }

  public BigInteger getN() {
    return n;
  }

  public BigInteger getD() {
    return d;
  }

  @Override
  public String toString() {
    return n.toString() + "/" + d.toString();
  }

  public static void main(String[] args) {

    System.out.println(new Fraction(2, 3).add(new Fraction(3, 4)));

  }

}
