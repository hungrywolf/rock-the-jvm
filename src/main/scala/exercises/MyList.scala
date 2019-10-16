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

  def map[B](transformer: MyTransformer[A,B]) : MyList[B]
  def flatMap[B](transformer: MyTransformer[A, MyList[B]]): MyList[B]
  def filter(predicate: MyPredicate[A]): MyList[A]
  def ++[B >: A](list: MyList[B]): MyList[B]

}

object Empty extends MyList[Nothing] {
  def head : Nothing = throw new NoSuchElementException
  def tail : MyList[Nothing] = throw new NoSuchElementException
  def isEmpty : Boolean = true
  def add[B >: Nothing](element: B) : MyList[B] =  new Cons(element, Empty)
  def printElements: String = ""

  def map[B](transformer: MyTransformer[Nothing,B]) : MyList[B] = Empty
  def flatMap[B](transformer: MyTransformer[Nothing, MyList[B]]): MyList[B] = Empty
  def filter(predicate: MyPredicate[Nothing]): MyList[Nothing] = Empty
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

  /**
    * [1,2,3].filter(n % 2 == 0) =
    * [2,3].filter(n % 2 == 0) =
    *  = new Cons(2, [3].filter(n %2 = 0
    *  = new Cons(2, Empty.filter(n %2 = 0
    *  = new Cons(2, Empty
    */
  def filter(predicate: MyPredicate[A]): MyList[A] = {
    if(predicate.test(h)) new Cons(h,t.filter(predicate))
    else t.filter(predicate)
  }

  /**
    * [1,2,3].map(n * 2)
    *   = new Cons(2,[2,3].map(n * 2)
    *   = new Cons(2,new Cons(4,[3].map(n * 2)
    *   = new Cons(2,new Cons(4,new Cons(6, Empty.map(n * 2
    *   = new Cons(2,new Cons(4,new Cons(6, Empty
    */
  def map[B](transformer: MyTransformer[A,B]) : MyList[B] = {
    new Cons(transformer.trsnform(h), t.map(transformer))
  }

  def flatMap[B](transformer: MyTransformer[A, MyList[B]]): MyList[B] = {
    new Cons(transformer.trsnform(h), t)
  }
}

trait MyPredicate[-T] {
  def test(elem: T): Boolean
}

trait MyTransformer[-A,B] {
  def trsnform(elem: A): B
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


  println(list5.map(new MyTransformer[Int,Int] {
    override def trsnform(elem: Int): Int = {
      elem * 2
    }
  }).toString)

  println(list5.filter(new MyPredicate[Int] {
    override def test(elem: Int): Boolean = elem % 2 == 0
  }).toString)

}

