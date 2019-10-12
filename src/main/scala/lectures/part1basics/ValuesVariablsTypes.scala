package lectures.part1basics

object ValuesVariablsTypes extends App {

  val x:Int = 42
  println(x)

  // vals are immutable
  // compiler can infer types

  val aString:String = "hello"
  val anotherStinf = "goodby"

  val aboolean: Boolean = false
  val aChar:Char = 'a'
  val anInt: Int = x
  val aShort:Short = 2134
  val aLong:Long = 12312312312312L
  val aFloat: Float = 2.0f
  val aDouoble :Double = 3.14

  // variables
  var aVariable: Int = 4
  aVariable = 5

}
