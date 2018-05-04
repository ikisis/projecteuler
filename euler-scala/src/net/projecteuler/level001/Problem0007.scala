package net.projecteuler.level001

import net.projecteuler.utils.{Prime, Stopwatch}

/*
By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.

What is the 10 001st prime number?
 */
object Problem0007 {

  def main(args: Array[String]): Unit = {

    Stopwatch.elapsed(brute_force)

  }

  def brute_force() = {
    var n = 0
    var i = 0
    while(n < 10001) {

      i+= 1
      if(Prime.isPrime(i)) {
        n += 1
      }
    }

    println(i)
  }

}
