package net.projecteuler.level001

import scala.math.BigInt
import java.math.BigInteger

/*
 * The prime factors of 13195 are 5, 7, 13 and 29.
 *
 * What is the largest prime factor of the number 600851475143 ?
 */
object Problem0003 {
  def main(args: Array[String]): Unit = {
    
    val n = 600851475143L
    
    def rec(n: Long, d: Long):Long = 
      if(n == d) d
      else {
        if(n % d == 0) rec(n/d, d)
        else rec(n,d + 1)
      }
      
    println(rec(n,2))
    
  }
}