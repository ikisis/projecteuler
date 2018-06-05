package net.projecteuler.level001

import net.projecteuler.utils.Stopwatch

import scala.annotation.tailrec

object p0012_HighlyDivisibleTriangularNumber {

  def main(args: Array[String]): Unit = {

    Stopwatch.elapsed(solution)

    Stopwatch.elapsed(solution_f)

    Stopwatch.elapsed(solution_f2)


  }

  def solution: Unit = {

    var n: Long = 0

    var i: Int = 0

    var count = 0
    while(count < 250) {

      i += 1

      n += i

      var d = 2
      count = 0
      while(d * d <= n) {

        if(n % d == 0) {
          count += 1
        }

        d += 1

      }

      count += 1

    }

    println(s"$i : $n")

  }

  def solution_f = {

    @tailrec
    def rec(n: Long, i: Int): Long= {

      var d = 2
      var count = 0
      while(d * d <= n) {
        if(n % d == 0)count += 1
        d += 1
      }

      if((count + 1) >= 250)n
      else rec(n + i, i + 1)

    }

    println(rec(1, 2))

  }

  def solution_f2 = {

    @tailrec
    def rec(n: Long, i: Int): Long= {

      @tailrec
      def count_rec(d: Int, count: Int): Int = {
        if(d * d >= n)count
        else if(n % d == 0)count_rec(d + 1, count + 1)
        else count_rec(d + 1, count)
      }

      if(count_rec(2, 1) >= 250)n
      else rec(n + i, i + 1)

    }

    println(rec(1, 2))

  }



}
