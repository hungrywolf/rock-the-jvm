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

 //when you need loops use tail recursion
  /**
    * 1. Concatenate a string n times
    * 2. IsPrime function tail recursive
    * 3. Fibonacci function, tail recursive
    */


    @tailrec
    def concatenateTailrec(aString: String, n:Int, accmulator: String) : String = {
      if(n <= 0) accmulator
      else concatenateTailrec(aString, n-1 , aString + accmulator)
    }

    println(concatenateTailrec("hello", 4, ""))

    def isPrime(n: Int) : Boolean = {
      @tailrec
      def isPrimeTialrec(t: Int, isStillPrime: Boolean) : Boolean = {
        if(!isStillPrime) false
        else if(t <= 1 ) true
        else isPrimeTialrec(t-1, n % t != 0 && isStillPrime)
      }

      isPrimeTialrec(n/2,true)
    }

  println(isPrime(3))
  println(isPrime(4))
  println(isPrime(37))

  def fibonacci(n: Int) : Int = {
    @tailrec
   def fibonacciTailrec(i: Int , last: Int, nextToLast: Int) : Int = {
     if(i >= n) last
     else fibonacciTailrec(i + 1, last + nextToLast, last)
   }
    if (n <= 2) 1
    else fibonacciTailrec(2,1,1)
  }

  println(fibonacci(10))

}
