package lectures.part1basics

object Functions extends App {

  def aFunction(a: String, b: Int) : String = {
      a + " " + b
    }

  println(aFunction("hello", 3))

  def aParamterLessFunction(): Int = 42
  println(aParamterLessFunction())
  println(aParamterLessFunction)

  def aRepeatedFunction(aString: String, n: Int ) : String = {
    if(n == 1) aString
    else aString + aRepeatedFunction(aString,n-1)
  }

  println(aRepeatedFunction("hello", 3))

  // WHEN YOU NEED LOOPS, USE RECURSION.

  def aFunctionWithEffects(aString: String): Unit = println(aString)

  def aBigFunction(n: Int) : Int = {
    def aSmallFunction(a: Int, b: Int): Int = a + b

    aSmallFunction(n, n-1)
  }

    /**
      * 1. A greeting function (name, age) => "Hi, my name is $name and I am $age years old"
      * 2. Factoial function 1 * 2 * 3 ... n
      * 3. A Fibonacci function
      *  f(1) = 1
      *  f(2) = 1
      *  f(n) = f(n-1) + f(n-2)
      * 4. Test if a number is prime
      */
  //1.
    def greetingForKids(name: String , age: String) : String = {
      s"Hi, my name is $name and I am $age years old"
    }

  //2.
    def factorial(n:Int) : Int = {
      if (n <= 0) 1
      else n * factorial(n-1)
    }

  println(factorial(10))

  //3.
  def fibonacci(n: Int) : Int = {
    if(n <= 2) 1
    else fibonacci(n-1) + fibonacci(n-2)
   }

  println(fibonacci(10))

  //4.
  def primeNumber(n: Int) : Boolean = {
    def isPrimeUntil(t: Int) : Boolean = {
      if(t <= 1) true
      else n % t != 0 && isPrimeUntil(t-1)
    }

    isPrimeUntil(n / 2)
  }
  println(primeNumber(3))
}
