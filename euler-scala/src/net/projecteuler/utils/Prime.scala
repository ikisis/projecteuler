package net.projecteuler.utils

object Prime {

  def factorization(n: Int): Array[(Int, Int)] = {

    val primes = Array.ofDim[Int](n + 1)

    var acc = n
    var i = 2
    while (i <= acc) {
      if (acc % i == 0) {
        acc = acc / i
        primes(i) = primes(i) + 1
      } else {
        i = i + 1
      }
    }
    
    
    for((a, b) <- primes.zipWithIndex; if a > 0) yield (b, a)    
    
  }

  def isPrime(n: Int): Boolean = {

    n match {
      case 1 => false
      case 2 => true
      case i: Int => {
        if(i % 2 == 0) true
        else {
          !(3 until n by 2).forall(n % _ == 0)
        }
      }
    }

  }

}