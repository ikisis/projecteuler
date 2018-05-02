package net.projecteuler.utils

object Stopwatch {

  def elapsed[A](f: => A) = {
    val s = System.nanoTime
    val ret = f
    println(s"time: ${(System.nanoTime - s)/1e6}ms")
    ret
  }

}
