package lectures.part2oop

object Inheritane extends App {

  // single class inheritance
  sealed class Animal {
    val creatureType = "wild"
    def eat = println("nomnom")
  }

  class Cat extends Animal {
    def crunch = {
      eat
      println("crunch crunch")
    }
  }

  val cat = new Cat
  cat.crunch


  // constructors
  class Person(name : String, age: Int) {
    def this(name: String) = this(name, 0)
  }
  class Adult(name: String, age: Int, idCard: String) extends Person(name)

  // overriding
  class Dog(override val creatureType: String) extends Animal {
//    override val creatureType = "domestic"
    override def eat = {
      super.eat
      println("hum hum")
    }
  }

  val dog = new Dog("K9")
  dog.eat
  println(dog.creatureType)


  val unkownAnimal : Animal = new Dog("K9")
  unkownAnimal.eat

  // overRIDING vs overLOADING

  // super

  // preventing override
  // 1. use the key word final on memeber
  // 2. use final on class
  // 3. seal the class  - extends classes in this file , prevent extention in other files

}
