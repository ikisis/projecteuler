package net.projecteuler.level001

/*
2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.

What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
 */
object Problem0005 {
  
  def main(args: Array[String]): Unit = {
  
    loop_solution
    
  }
  
  def loop_solution = {
        val primes = Array.ofDim[Int](20)
    
    for(n <- (10 to 20)) {
      val parts = Array.ofDim[Int](20)
      var acc = n
      var i = 2
      while(i <= acc) {
        if(acc % i == 0) {
          acc = acc / i
          parts(i) = parts(i) + 1
        } else {
          i = i + 1
        }
      }
      
      for(p <- (0 until parts.length)) {
        if(primes(p) < parts(p)) {
          primes(p) = parts(p)
        }
      }
    }
    var result = 1;
    
    for(p <- (0 until primes.length)) {
      if(primes(p) > 0) {
        for(e <- 1 to primes(p)) {
          result = result * p
        }
      }
    }
    
    println(result)
  }
}