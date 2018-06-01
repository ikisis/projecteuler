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

    //for((a, b) <- primes.zipWithIndex; if a > 0) yield (b, a)

    primes.indices.toArray.zip(primes)

  }

  def isPrime(n: Int): Boolean = {

    def isPrime0(n: Int): Boolean = {

      var i = 2;

      while(i * i < n) {

        if(n % i == 0) {
          return false
        }

        i += 1;
      }

      true

    }

    n match {
      case 1 => false
      case 2 => true
      case i: Int => {
        if(i % 2 == 0) false
        else {
          isPrime0(n)
        }
      }
    }



  }



  /*

      boolean flag = true;

      for (int j = 2; j * j < i; j++) {
        if (i % j == 0) {
          flag = false;
          break;
        }
      }



   */

}