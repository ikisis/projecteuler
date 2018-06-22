package net.projecteuler.level001

import net.projecteuler.utils.Stopwatch

object p0015_LatticePaths {

  def main(args: Array[String]): Unit = {

    Stopwatch.elapsed(solution_loop)

  }

  def solution_loop = {

    var x, y = 21

    val matrix = Array.ofDim[Long](x,y)

    for{
      i <- 0 until x
      j <- 0 until y
    } {

      if(i == 0 || j == 0) {

        matrix(i)(j) = 1

      } else {
        matrix(i)(j) = matrix(i - 1)(j) + matrix(i)(j - 1)
      }

    }

    println(matrix(x - 1)(y - 1))
    

  }

}
