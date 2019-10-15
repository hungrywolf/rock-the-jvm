package lectures.part2oop

object Generics extends App {

  class MyList[+A] {
      // use the type A
    def add[B >: A](element :B) : MyList[B] = ???
  }

  class MyMap[Key,Value]

  val listOfInteger = new MyList[Int]
  val listOfString = new MyList[String]

  // generic method
  object MyList {
    def empty[A] : MyList[A] = ???

    /**
      * A = Cat
      * B = Animal
      */
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
  // animalList.add[new Dog] HARD QUESTION. => we return a list of animal

  // 2. No0 = INVARIANCE
  class InvariantList[A]
  val invariantAnimalList : InvariantList[Animal] = new InvariantList[Animal]

  // 3. Hell , no! CONTRAVARIANCE
  class Trainer[-A]
  val trainer: Trainer[Cat] = new Trainer[Animal]

  // bounded type
  class Cage[A <: Animal](animal :A)
  val cage = new Cage(new Dog)

  class Car
  //  val newcage = new Cage(new Car) // will not work


  // expand MyList to be generic

}
