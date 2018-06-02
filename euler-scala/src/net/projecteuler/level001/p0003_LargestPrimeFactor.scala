package net.projecteuler.level001

import scala.math.BigInt
import java.math.BigInteger

import net.projecteuler.utils.Stopwatch

import scala.annotation.tailrec

/*
 * The prime factors of 13195 are 5, 7, 13 and 29.
 *
 * What is the largest prime factor of the number 600851475143 ?
 */
object p0003_LargestPrimeFactor {
  def main(args: Array[String]): Unit = {

    Stopwatch.elapsed(solution)

    Stopwatch.elapsed(solution_loop)

  }

  def solution = {
    val n = 600851475143L

    @tailrec
    def rec(n: Long, d: Long):Long =
      if(n == d) d
      else {
        if(n % d == 0) rec(n/d, d)
        else rec(n,d + 1)
      }

    println(rec(n,2))
  }

  def solution_loop = {
    var a = 600851475143L
    var b = 5

    while(a > b) {

      if(a % b == 0) {
        a /= b
      } else {
        b += 1
      }

    }

    println(b)


  }


}