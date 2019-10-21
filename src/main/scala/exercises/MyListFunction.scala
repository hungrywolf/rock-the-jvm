package exercises

abstract class MyListFunction[+A] {
  /**
    * head  = first element
    * tail = remainder of the list
    * isEmply =  is empty
    * add(int) => new list with this element added
    * toString => a string representation of the list
    *
    */

  def head : A
  def tail : MyListFunction[A]
  def isEmpty : Boolean
  def add[B >: A](element: B) : MyListFunction[B]
  def printElements : String
  // polymorphic call
  override def toString: String = s"[${printElements}]"

  //higher - order function
  def map[B](transformer: A => B) : MyListFunction[B]
  def flatMap[B](transformer: A => MyListFunction[B]): MyListFunction[B]
  def filter(predicate: A => Boolean): MyListFunction[A]
  def ++[B >: A](list: MyListFunction[B]): MyListFunction[B]

}

case object EmptyFunction extends MyListFunction[Nothing] {
  def head : Nothing = throw new NoSuchElementException
  def tail : MyListFunction[Nothing] = throw new NoSuchElementException
  def isEmpty : Boolean = true
  def add[B >: Nothing](element: B) : MyListFunction[B] =  new ConsFunction(element, EmptyFunction)
  def printElements: String = ""

  def map[B](transformer: Nothing => B) : MyListFunction[B] = EmptyFunction
  def flatMap[B](transformer: Nothing => MyListFunction[B]): MyListFunction[B] = EmptyFunction
  def filter(predicate: Nothing => Boolean): MyListFunction[Nothing] = EmptyFunction
  def ++[B >: Nothing](list: MyListFunction[B]): MyListFunction[B] = list
}

case class ConsFunction[+A](h: A, t: MyListFunction[A]) extends MyListFunction[A] {
  def head : A = h
  def tail : MyListFunction[A] = t
  def isEmpty : Boolean = false
  def add[B >: A](element: B) : MyListFunction[B] = new ConsFunction(element, this)
  def printElements: String = {
    if (tail.isEmpty) {
      s" ${h}"
    } else s"${h}  ${t.printElements}"
  }

  /**
    * [1,2,3].filter(n % 2 == 0) =
    * [2,3].filter(n % 2 == 0) =
    *  = new Cons(2, [3].filter(n %2 = 0
    *  = new Cons(2, Empty.filter(n %2 = 0
    *  = new Cons(2, Empty
    */
  def filter(predicate: A => Boolean): MyListFunction[A] = {
    if(predicate(h)) new ConsFunction(h,t.filter(predicate))
    else t.filter(predicate)
  }

  /**
    * [1,2,3].map(n * 2)
    *   = new Cons(2,[2,3].map(n * 2)
    *   = new Cons(2,new Cons(4,[3].map(n * 2)
    *   = new Cons(2,new Cons(4,new Cons(6, Empty.map(n * 2
    *   = new Cons(2,new Cons(4,new Cons(6, Empty
    */
  def map[B](transformer: A => B) : MyListFunction[B] = {
    new ConsFunction(transformer(h), t.map(transformer))
  }

  /**
    *[1,2].flatMap(n => [n, n + 1]
    * [1,2] ++ [2].flatMap[n => n +1
    * [1,2] ++ [2,3] ++ Empty
    */
  def flatMap[B](transformer: A => MyListFunction[B]): MyListFunction[B] = {
    transformer(h) ++ t.flatMap(transformer)
  }

  /**
    * [1,2] ++ [3,4,5]
    * = new Cons(1, [2] ++ [3,4,5]
    * = new Cons(1,new Cons(2, Emprty ++ [3,4,5]
    * = new Cons(1,2 ++ [3,4,5]
    * = new Cons(1, new Cons(2,new Cons(3, new Cons(4, new Cons(6 ,Empty
    */
  def ++[B >: A](list: MyListFunction[B]): MyListFunction[B] = {
    new ConsFunction(h, t ++ list)
  }
}

object ListTestFunction extends App {
  val list:MyListFunction[Int] = new ConsFunction(0,EmptyFunction)
  println(list.add(99).head)
  list.add(10)
  list.add(11)
  list.add(12)
  println(list.head)
  println(list toString)
  val list2:MyListFunction[Int] = new ConsFunction(1,list)
  val list3:MyListFunction[Int] = new ConsFunction(2,list2)
  val list4:MyListFunction[Int] = new ConsFunction(3,list3)
  val list5:MyListFunction[Int] = new ConsFunction(4,list4)
  println(list5.tail.head)
  println(list5.toString)
  val list6 = list5


  println(list5.map(new Function1[Int,Int] {
    override def apply(elem: Int): Int = {
      elem * 2
    }
  }).toString)

  println(list5.map(elem => {
      elem * 2
  }).toString)

  println(list5.filter(new Function1[Int,Boolean] {
    override def apply(elem: Int): Boolean = elem % 2 == 0
  }).toString)

  println(list5.filter(elem =>  {
    elem % 2 == 0
  }).toString)

  println((list5 ++ list).toString)

  println(list5.flatMap(new Function1[Int,MyListFunction[Int]] {
    override def apply(elem: Int): MyListFunction[Int] = {
      new ConsFunction(elem, new ConsFunction(elem + 1, EmptyFunction))
    }
  }).toString)

  println(list5.flatMap(elem => {
      new ConsFunction(elem, new ConsFunction(elem + 1, EmptyFunction))
  }).toString)



  println(list5 == list6)

}

