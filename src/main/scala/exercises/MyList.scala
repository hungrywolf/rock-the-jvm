package exercises

abstract class MyList[+A] {
  /**
    * head  = first element
    * tail = remainder of the list
    * isEmply =  is empty
    * add(int) => new list with this element added
    * toString => a string representation of the list
    *
    */

  def head : A
  def tail : MyList[A]
  def isEmpty : Boolean
  def add[B >: A](element: B) : MyList[B]
  def printElements : String
  // polymorphic call
  override def toString: String = s"[${printElements}]"

}

object Empty extends MyList[Nothing] {
  def head : Nothing = throw new NoSuchElementException
  def tail : MyList[Nothing] = throw new NoSuchElementException
  def isEmpty : Boolean = true
  def add[B >: Nothing](element: B) : MyList[B] =  new Cons(element, Empty)
  def printElements: String = ""
}

class Cons[+A](h: A, t: MyList[A]) extends MyList[A] {
  def head : A = h
  def tail : MyList[A] = t
  def isEmpty : Boolean = false
  def add[B >: A](element: B) : MyList[B] = new Cons(element, this)
  def printElements: String = {
    if (tail.isEmpty) {
      s" ${h}"
    } else s"${h}  ${t.printElements}"
  }
}

object ListTest extends App {
  val list:MyList[Int] = new Cons(0,Empty)
  println(list.add(99).head)
  list.add(10)
  list.add(11)
  list.add(12)
  println(list.head)
  println(list toString)
  val list2:MyList[Int] = new Cons(1,list)
  val list3:MyList[Int] = new Cons(2,list2)
  val list4:MyList[Int] = new Cons(3,list3)
  val list5:MyList[Int] = new Cons(4,list4)
  println(list5.tail.head)
  println(list5.toString)

}

