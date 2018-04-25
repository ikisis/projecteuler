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

}