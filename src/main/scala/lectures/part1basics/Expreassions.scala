package lectures.part1basics

object Expreassions extends App {

  val x = 1 + 2
  println(x)

  println(2 + 3 * 4)

  println(1 == x)

  println(!(1 == x))

  var aVariable = 2
  aVariable += 3 // side effect
  println(aVariable)

  // Instruction (DO) vs Expressions (VALUE)

  //If expression
  val aCondition = true
  val aConditionValue = if(aCondition) 5 else 3
  println(aConditionValue)
  println(if(aCondition) 5 else 3)
  println(1 + 3)

  // NEVER WRITE THIS AGAIN
  var i = 0
  val aWhile = while(i < 10){
    println(i)
    i += 1
  }

  println(aWhile) // Unit

  // EVERYTHING in Scala is an Expression !

  val aWeirdValue = (aVariable = 3) // Unit === void
  println(aWeirdValue)

  // side effects : println(). whiles, reassigning

  // Code blocks

  val aCodeBlock = {
    val y = 2
    val z = y + 1

    if(z > 2) "hello" else "goodbye"
  }

  //val anotherValue = z + 1 will not work

  // 1. diff between "hello, world" and println("hello, world")
  // 2.
  val someValue = {
    2 < 5
  }
  println(someValue)


  val someOtherValue = {
    if(someValue) 2323 else 231312222

    42
  }
  println(someOtherValue)

}
