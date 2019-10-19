package lectures.part2oop

object Exceptions extends App {
  val x: String =null;
  //println(x.length)

  // throwing and catching exceptions

  // 1. throwing Exceptions

  //val aWeirdValue:String = throw new NullPointerException

  // throwable classes extends Throwable class .
  // Exception and Error are major Throwable sutypes

  // 2. how to catch exceptions
  def getInt(withException: Boolean) : Int = {
    if(withException) throw new RuntimeException("No int for you!")
    else 42
  }

  val potenialFail = try {
    getInt(false)
  } catch {
    case e: RuntimeException => 43 //println("caought a RunTime exceptiosn ! ")

  } finally {
    // code that will get excuted NO MATTER WHAT
    // optional
    // does not infuence the ruten of the type of this expression
    // use finally only for side effects

    println("finally")
  }


  println(potenialFail)

  class MyException extends Exception
  val exception = new MyException

  //throw exception

  /*
  1. Crash you program with an OutofMempryError
  2. Crash with SOError
  3. Pockect Calculater
    -add(x,y)
    -sub(x,y)
    -multi(x,y)
    -div(x,y)

    Throw
      -OverflowException if add(x,y) exceeds Int.MAX_VALUE
      -UnderflowException if sub(x,y) exceeds Int.MIN_VALUE
      -MathCalculationException for division by 0
   */

  // OOM
  val array = Array.ofDim(Int.MaxValue)

  //SO
  def infinte : Int = 1+ infinte
  val noLimit = infinte

  class OverflowException extends RuntimeException
  class UnderflowException extends RuntimeException
  class MathCalculationException extends RuntimeException("Division by 0")
  object PocketCalculater {
    def add(x:Int, y: Int) = {
      val result = x + y

      if(x > 0 && y > 0 && result < 0 ) throw new OverflowException
      else if(x < 0 && y < 0 && result > 0 ) throw new UnderflowException
      else result
    }

    def sub(x:Int, y: Int) = {
      val result = x - y

      if(x > 0 && y < 0 && result < 0 ) throw new OverflowException
      else if(x < 0 && y > 0 && result > 0 ) throw new UnderflowException
      else result
    }

    def multi(x:Int, y: Int) = {
      val result = x * y

      if(x > 0 && y > 0 && result < 0 ) throw new OverflowException
      else if(x < 0 && y < 0 && result < 0 ) throw new OverflowException
      else if(x > 0 && y < 0 && result > 0 ) throw new UnderflowException
      else if(x < 0 && y < 0 && result > 0 ) throw new UnderflowException
      else result
    }

    def div(x:Int, y: Int) = {
      if(y == 0 ) throw new MathCalculationException
      else x/y
    }
  }

  println(PocketCalculater.add(Int.MaxValue, 10))
  println(PocketCalculater.div(2, 0))


}
