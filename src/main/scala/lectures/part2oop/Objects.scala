package lectures.part2oop

object Objects extends App {
 // Scala does not have class level functionality  ("static")

  object Person { //type + its only instance
    // static / class  - level functionality
    val N_EYES = 2
    def canFlay : Boolean = false

    def apply(mother: Person, father: Person) : Person = new Person("Bobbie")
  }

  class Person(val name: String) {
    // instance-level functionality
  }

  // COMPANIONS

  println(Person.N_EYES)
  println(Person canFlay)


  // Scala object  = singleton instance
  val mary = new Person("mary")
  val john = new Person("john")
  println(mary == john)

  val person1 = Person
  val person2 = Person
  println(person1 == person2)

  val boobie = Person(mary, john)

  //Scala Applications = Sala object with
  // def main(args:Array[String]): Unit

}
