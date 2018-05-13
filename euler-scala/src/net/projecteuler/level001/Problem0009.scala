package net.projecteuler.level001

import net.projecteuler.utils.Stopwatch

/*
 * A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
 *
 * a^2 + b^2 = c^2
 * For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2.
 *
 * There exists exactly one Pythagorean triplet for which a + b + c = 1000.
 * Find the product abc.
 */

object Problem0009 {

  def main(args: Array[String]): Unit = {

    Stopwatch.elapsed(solution_loop)

  }

  def solution_loop = {

    for(c <- (1000 to 3) by -1) {

      val ab = 1000 - c

      for(b <- (ab - 1 to 2) by -1) {

        val a = ab - b

        if(a < b && b < c) {

          if(a * a + b * b == c * c) {
            println(a * b * c)
          }

        }

      }

    }

  }

}
