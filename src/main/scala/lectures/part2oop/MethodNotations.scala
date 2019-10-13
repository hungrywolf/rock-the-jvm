package lectures.part2oop

object MethodNotations extends App {

  class Person(val name: String, favoriteMove: String,val age: Int = 0) {
    def likes(movie: String) : Boolean = movie == favoriteMove
    def +(person: Person) : String = s"${this name} is hanging out with ${person.name}"
    def +(nickName: String) : Person = new Person(s"$name (${nickName})", favoriteMove)
    def unary_! : String =  s"${name} what the heck?!"
    def unary_+ : Person = new Person(name,favoriteMove,age + 1)
    def isAlive: Boolean = true
    def learns(thing: String) = s"$name is learning $thing"
    def learnScala =  this learns "Scala"
    def apply(): String = s"Hi, my name is $name and I like $favoriteMove"
    def apply(n: Int): String = s"$name watched $favoriteMove $n times"
  }

  val mary = new Person("Mary", "Inception")
  println(mary.likes("Inception"))
  println(mary likes "Inception")  // equivalent
    // infix notation = operator notation (syntactic sugar)

  // "operators" in scala
  val tom = new Person("Tom", "Fight Club")
  println(mary + tom)
  println(mary.+(tom))

  println(1+2)
  println(1.+(2))

  // All OPERATORS ARE METHODS.
  // AKKA actors have ! ?

  // prefix notation
  val x = -1
  val y = 1.unary_-
  // unary_ prefix works only with - + ~ !
  println(!mary)
  println(mary.unary_!)

  // post fix notation
  println(mary.isAlive)
  println(mary isAlive)

  //apply
  println(mary.apply())
  println(mary())  // equivalent

  /**
    * 1. Overload the + operator
    *   mary + "the rockstar" => new person " Mary (the rockSat)"
    *
    * 2. Add an age to the Person class
    * Add a unary +  operator => new person with the age + 1
    * +mary => mary woth the age incrementer
    *
    * 3. Add a "learns" method in the Person class => " Mary learns Scala"
    * Add a learnScala method, calls learns method with "Scala" .
    * Use it in postfix notation
    *
    * 4. Overload the apply method
    *   mary.apply(2) => "Mary watched Inception 2 time"
    *
    */

    println((mary + "the Rockstar")())
    println((+mary).age)
    println(mary learnScala)
    println(mary(10))

}
