package lectures.part2oop

object Generics extends App {

  class MyList[A] {
      // use the type A
  }

  class MyMap[Key,Value]

  val listOfInteger = new MyList[Int]
  val listOfString = new MyList[String]

  // generic method
  object MyList {
    def empty[A] : MyList[A] = ???
  }
  val emptyListOfIntegers = MyList.empty[Int]

  // variance problem
  class Animal
  class Cat extends Animal
  class Dog extends Animal

  // 1. yes List[Cat] extends List[Animal] = COVARIANCE
  class CovariantList[+A]
  val animal: Animal = new Cat
  val animalList: CovariantList[Animal] = new CovariantList[Cat]
  // animalList.add[new Dog] HARD QUESTION.

  // 2. No0 = INVARIANCE
  class InvariantList[A]
  val invariantAnimalList : InvariantList[Animal] = new InvariantList[Animal]

  // 3. Hell , no! CONTRAVARIANCE
  class ContravarianList[-A]
  val contravarianList: ContravarianList[Cat] = new ContravarianList[Animal]

}
