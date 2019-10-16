package lectures.part2oop

object CaseClasses extends App {

  case class Person(name: String, age: Int)
  // 1. class parameters are fields
  val jim = new Person("jim",34)
  println(jim.name)

  //2. sensible to String
  // println(instance) = println(instance.toString) // syntactic sugar
  println(jim)

  // 3. equals and hashCode implemented OOTB
  val jim2 = new Person("jim", 34)
  println(jim == jim2)

  // 4. CCs have handy copy methods
  val jim3 = jim.copy(age=3)
  println(jim3)

  //5. CCs have companion objects
  val thePerson = Person
  val mary = Person("Mary", 23)

  // 6. CCs are serializable
  // Akka

  // 7. CCs have extractor patterns = CCs can be used in PATTERN MATCHING
  case object UnitedKingdom {
    def name: String = "The UK of GB an NI"
  }

  /**
    * Expand MyList - use case classes and case objects
    */
}
