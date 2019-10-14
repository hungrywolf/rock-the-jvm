package exercises

abstract class MyList {
  /**
    * head  = first element
    * tail = remainder of the list
    * isEmply =  is empty
    * add(int) => new list with this element added
    * toString => a string representation of the list
    *
    */

  def head : Int
  def tail : MyList
  def isEmpty : Boolean
  def add(element: Int) : MyList
  def printElements : String
  // polymorphic call
  override def toString: String = s"[${printElements}]"

}

object Empty extends MyList {
  def head : Int = throw new NoSuchElementException
  def tail : MyList = throw new NoSuchElementException
  def isEmpty : Boolean = true
  def add(element: Int) : MyList =  new Cons(element, Empty)
  def printElements: String = ""
}

class Cons(h: Int, t: MyList) extends MyList {
  def head : Int = h
  def tail : MyList = t
  def isEmpty : Boolean = false
  def add(element: Int) : MyList = new Cons(element, this)
  def printElements: String = {
    if (tail.isEmpty) {
      s" ${h}"
    } else s"${h}  ${t.printElements}"
  }
}

object ListTest extends App {
  val list = new Cons(0,Empty)
  println(list.add(99).head)
  list.add(10)
  list.add(11)
  list.add(12)
  println(list.head)
  println(list toString)
  val list2 = new Cons(1,list)
  val list3 = new Cons(2,list2)
  val list4 = new Cons(3,list3)
  val list5 = new Cons(4,list4)
  println(list5.tail.head)
  println(list5.toString)

}

