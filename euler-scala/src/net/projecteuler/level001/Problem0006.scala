package net.projecteuler.level001

/*
The sum of the squares of the first ten natural numbers is,

1^2 + 2^2 + ... + 10^2 = 385
The square of the sum of the first ten natural numbers is,

(1 + 2 + ... + 10)^2 = 552 = 3025
Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is 3025 − 385 = 2640.

Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.
 */
object Problem0006 {
  
  def main(args: Array[String]): Unit = {
    
    var sum_of_square = 0
    var square_of_sum = 0
    
    1.to(100).foreach{ i => 
      sum_of_square += i * i
      square_of_sum += i
    }
    
    println(s"${square_of_sum * square_of_sum - sum_of_square}")
    
  }
  
  
}