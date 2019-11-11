package lectures.part1as

import scala.util.Try

object DarkSugars extends App {

  // sysnatx sugar #1: method with single param
  def singleArgMethod(arg: Int) : String = s"$arg little ducks ... "
  val description = singleArgMethod {
    42
  }

  val atryUnstance = Try {
    throw new RuntimeException
  }

  List(1,2,3).map {
    x => x + 1
  }

  // sysnatx sugar #2 : single abstract method
  trait Action {
    def act(x: Int): Int
  }

  val anInstance :Action = new Action {
    override def act(x: Int): Int = {
     0
    }
  }

  val aFunkyInstance : Action = (x: Int) => x + 1 // magic

  // example : Runnables
  val aThread = new Thread(new Runnable {
    override def run(): Unit = println("hello, Scala")
  })

  val aSweeterThread :Thread = new Thread(() => println("sweet scala"))

  abstract class AnAbstractType {
    def implemented: Int = 23
    def f(a: Int): Unit
  }

  val anAbstractType: AnAbstractType = (a: Int) => println("sweet")


  // sysntax sugar #3 : the :: and #:: method are special
  val prependedList = 2 :: List(3,4)
  // 2.::(List(3,4))
  // List(3,4).::(2)
  // ?!

  // scala spec: last char decides associativity of method
  1 :: 2 :: 3 :: List(4, 5)
  List(4,5).::(3).::(2).::(1) // equivalent

  class MyStream[T] {
    def -->:(value : T) : MyStream[T] = this
  }

  val myStream = 1 -->: 2 -->: 3 -->: new MyStream[Int]

  // syntax sugar #4: multi-word method naming

  class TeenGirl(name: String) {
    def `and then said`(gossip: String) = println(s"$name said $gossip")
  }

  val lilly = new TeenGirl("Lilly")
  lilly `and then said` "Scala is so sweet!"

  // syntax sugar #5: infix types

  class Composite[A, B]
  val composite: Int Composite String = ???

  class -->[A,B]
  val towords : Int --> String = ???

  // syntax sugar #6: update() is very special, much like apply()
  val anArray = Array(1,2,3)
  anArray(2)= 7 // rewritten to anArray.update(2, 7))
  // used in mutable collections
  // remmmber apply AND update

  // syntax sugar #7: setters for mutable containers
  class Mutable {
    private var internalMember: Int = 0 // private for OO encapsulation
    def member: Int = internalMember // getter
    def member_=(value: Int): Unit = internalMember = value
  }

  val aMutbaleContainer = new Mutable
  aMutbaleContainer.member = 42  // rewritten as aMutbaleContainer.member_=(42)
}
