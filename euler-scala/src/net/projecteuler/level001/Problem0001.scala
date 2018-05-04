package net.projecteuler.level001

import net.projecteuler.utils.Stopwatch

/*
If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.

Find the sum of all the multiples of 3 or 5 below 1000.
*/

object Problem0001 {
  def main(args: Array[String]): Unit = {

    Stopwatch.elapsed(solution)

  }

  def solution = {

    val a = (1 until 1000).filter( a => a % 3 == 0 || a % 5 == 0).foldLeft(0)(_ + _)

    println(a)
  }
}