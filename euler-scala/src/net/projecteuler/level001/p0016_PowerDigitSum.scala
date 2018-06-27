package net.projecteuler.level001

import net.projecteuler.utils.Stopwatch

object p0016_PowerDigitSum {

  def main(args: Array[String]): Unit = {

    Stopwatch.elapsed(solution_bigint)

  }

  def solution_bigint = {

    val n = BigInt(2)

    val ans = n.pow(1000).toString.map(_.toString).foldLeft(0)((sum, s) => sum + Integer.parseInt(s))

    println(ans)

  }

}
