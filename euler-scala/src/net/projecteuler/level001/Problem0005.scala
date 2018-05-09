package net.projecteuler.level001

import net.projecteuler.utils.{Prime, Stopwatch}

/*
2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.

What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
 */
object Problem0005 {
  
  def main(args: Array[String]): Unit = {
  
    Stopwatch.elapsed(loop_solution)
    
  }
  
  def loop_solution = {
    val primes = Array.ofDim[Int](20 + 1)
    
    for(n <- (10 to 20)) {
      val parts = Prime.factorization(n)
      
      for(p <- parts) {
        if(primes(p._1) < p._2) {
          primes(p._1) = p._2
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