package net.projecteuler.level001

import scala.math.BigInt
import java.math.BigInteger

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