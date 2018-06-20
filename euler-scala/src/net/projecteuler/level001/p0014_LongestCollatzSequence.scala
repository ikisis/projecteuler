package net.projecteuler.level001

import net.projecteuler.utils.Stopwatch

import scala.annotation.tailrec

object p0014_LongestCollatzSequence {

  def main(args: Array[String]): Unit = {

    Stopwatch.elapsed(solution)

    Stopwatch.elapsed(brute_force_loop)

  }

  def brute_force_loop = {

    var n = 1

    var max = 0

    var max_n = 0

    while(n < 1000000) {

      var i: Long = n

      var len = 1

      while(i != 1) {

        if(i % 2 == 0) {
          i = i / 2
        } else {
          i = 3 * i + 1
        }

        len += 1

      }

      if(len > max) {
        max = len
        max_n = n
      }

      n += 1
    }

    println(s"$max_n : $max")

  }

  def solution = {

    /*
    n → n/2 (n is even)
    n → 3n + 1 (n is odd)
     */

    var memo = Map[Long, Int]()

    @tailrec
    def calc0(s: Long, n: Long, len: Int): Int = {

      memo.get(n).map(_ + len - 1) match {
        case None => {
          if(n == 1) {
            memo = memo.updated(s, len)
            len
          } else if (n % 2 == 0){
            calc0(s, n / 2, len + 1)
          } else {
            calc0(s, 3 * n + 1, len + 1)
          }
        }
        case Some(l) => l
      }

    }

    def calc(n: Long): Int = {
      calc0(n, n, 1)
    }

    var max = 0
    var max_n = 0

    for(n <- 1 to 1000000) {
      val len = calc(n)
      if(len > max) {
        max = len
        max_n = n
      }
    }

    println(s"$max_n : len-> $max")

  }

}
