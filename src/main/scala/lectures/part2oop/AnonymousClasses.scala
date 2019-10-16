package lectures.part2oop

object AnonymousClasses extends App {
  abstract class Animal {
    def eat: Unit
  }

  val funnyAnimal: Animal = new Animal{
    override def eat: Unit = {
      println("nomnom ... ")
    }
  }
  /**
    * class AnonymousClasses$$anon$1 extends Animal {
    *    override def eat: Unit = {
    *     println("nomnom ... ")
    *    }
    *   }
    *
    *   val funnyAnimal: Animal = new AnonymousClasses$$anon$1
    */

  funnyAnimal.eat

  class Person(name: String) {
    def sayHi: Unit = println(s"Hi, my name is $name")
  }

  val jim = new Person("Jim") {
    override def sayHi: Unit = println(s"Hi , my name is jim")
  }

  /**
    * 1. Generi trait MyPredicate[-T]
    * 2. Generic trait MyTranformar[-A,B]
    * 3. MyList:
    *   - map transfomar => MyList
    *   - fileter predicate => MyList
    *   - flatMap transfor from A to MyList[B] => MyList[B]
    *
    *   class EventPredicate extends Mypredite[Int]
    *   class StringToTransformer extends MyTransformer[String, Int]
    *
    *   [1,2,3].map(n * 2) = [2,4,6]
    *   [1,2,3,4].filter(n%2) = [2,4]
    *   [1,2,3].flatMap(n => [n, n+1]) => [1,2,2,3,3,4]
    *
    */
}
