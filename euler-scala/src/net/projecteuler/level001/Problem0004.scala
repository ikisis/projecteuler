package net.projecteuler.level001

/*
A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.

Find the largest palindrome made from the product of two 3-digit numbers.
 */
object Problem0004 {
  def main(args: Array[String]): Unit = {
    
    //11(9091a + 910b + 100c)
    
    for{ 
      a <- 9 to 1 by -1
      b <- 9 to 0 by -1 
      c <- 9 to 0 by -1 
      } {
      
      val n = 9091 * a + 910 * b + 100 * c
      
      def rec(div:Int):Int = {
        
        if(div <= 10) 0
        else if(n % div == 0) 
          if(n / div > 999) 0
          else n * 11
        else rec(div - 1)
        
      }
      
      val nn = rec(90)
      
      if(nn != 0) {
        println(nn)
        return
      }
    }
  }
}