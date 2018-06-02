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

object p0009_SpecialPythagoreanTriplet {

  def main(args: Array[String]): Unit = {

    Stopwatch.elapsed(solution_loop)

    Stopwatch.elapsed(solution_loop2)

    Stopwatch.elapsed(solution_loop3)

  }

  def solution_loop2 = {

    var c = 997

    while(c >= 3) {

      val ab = 1000 - c

      var b = ab - 1

      while(b >= 2) {

        val a = ab - b

        if(a < b && b < c) {

          if(a * a + b * b == c * c) {
            println(a * b * c)
          }

        }

        b -= 1

      }

      c -= 1
    }

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

  def solution_loop3 = {

    val p = (for {
      c <- (1000 to 3) by - 1
      ab = 1000 -c
      b <- (ab - 1 to 2) by -1
      a = ab - b
      if a < b && b < c
      if a * a + b * b == c * c
    } yield a * b * c).apply(0)
    println(p)

  }


}
