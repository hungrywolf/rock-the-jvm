package lectures.part1basics

object StringOps extends App {
  val str : String = "Hi , all"

  println(str.charAt(2))
  println(str.substring(0,4))
  println(str.split(" ").toList)
  println(str.startsWith("Hi"))
  println(str.replace("Hi","Hello"))
  println(str.toLowerCase())
  println(str.length)


  // scala
  val aNumberString = "45"
  val aNumber = aNumberString.toInt

  println('a' +: aNumberString :+ 'z')
  println(str.reverse)
  println(str.take(2))

  // Scala-specifics string inerpolators.

  // S-Inerpolators
  val name = "David"
  val age = 12
  val greeting =s"Hello, my mane is  $name and I am $age years old"
  val anotherGreeting = s"Hello, my name is $name and I will be turning ${age + 1} years old"
  println(anotherGreeting)

  //F-Inerpolators
  val speed = 1.2f
  val myth = f"$name%s can eat $speed%2.2f burgers per minute"
  println(myth)

  // raw-Inerpolators
  println(raw"this is a \n newline")
  val escaped = "this is a \n newline"
  println(raw"$escaped")

}
