package net.projecteuler.level001

import net.projecteuler.utils.{Prime, Stopwatch}

object Problem0010 {

  def main(args: Array[String]): Unit = {


    Stopwatch.elapsed(sieve(2000000))

  }


  def sieve(n: Int) = {

    val sieve = Array.ofDim[Boolean](n + 1)


    var sum = 2L

    var i = 3
    while(i <= n) {

      if(!sieve(i) && Prime.isPrime(i)) {
        sum += i

        var j = i + i
        while(j <= n) {
          sieve(j) = true
          j += i
        }
      }

      i += 2

    }


    println(sum)

  }

}
