package lectures.part1basics

import scala.annotation.tailrec

object Recursion extends App {


  def factorial(n:Int) : Int = {
    if (n <= 0) 1
    else {
      println(s"Computing factorial of ${n} - I first factorail of ${n-1}")
      val result = n * factorial(n-1)
      println(s"Computed factorial of ${n}")

      result
    }
  }

  println(factorial(10))
  //println(factorial(5000))

  def anotherFactorial(n: Int) : BigInt = {
  @tailrec
    def factHelp(x: Int, accmulator: BigInt) : BigInt = {
      if(x <= 1) accmulator
      else factHelp(x - 1, x * accmulator) //tail recursion  = use recursive call as the LAST expression
    }

    factHelp(n,1)
  }

  println(anotherFactorial(5000))


}
