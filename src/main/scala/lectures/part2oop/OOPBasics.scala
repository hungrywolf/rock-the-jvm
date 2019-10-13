package lectures.part2oop

object OOPBasics extends App {
   val person = new Person("john", 26)
  println(person.age)
  println(person.x)

  person.greet("Daniel")
  person.greet()

  val author = new Writer("Charles", "Dickens", 1812)
  val novel = new Novel("Great Expectations", 1861, author)

  println(novel.autherAge)
  println(novel.isWrittenBy(author))

  val counter = new Counter
  counter.inc.print
  counter.inc.inc.inc.print
  counter.inc(10).print
}

// constructor
class Person(name:String, val age: Int = 0) {
  // body
  val x = 2

  println(1 + 3)

  def greet(name: String): Unit = println(s"${this.name} says: Hi, $name")

  //overloading
  def greet(): Unit = println(s"Hi, I am $name")

  // multiple constructor
  def this(name: String) = {
    this(name, 0)
  }

  def this() = this("John Doe")
}

// class parameters are not fields


/**
  * Novel and a Writer
  * Writer: first name , surname , year
  *   - method full name
  *
  * Novel : neme , year of release, author
  *   - authorAge
  *   - isWrittenBy
  *   - copy (new year of release = new instance of Novel )
  */

class Writer(firstName :String , surName: String,val year: Int) {
  def fullName : String = s"${firstName} ${surName}"
}

class Novel(name: String , year : Int, author: Writer) {
  def autherAge = year - author.year
  def isWrittenBy(author: Writer) = author == this.author
  def copy(newYear : Int) : Novel = new Novel(name, newYear, author)
}

/**
  * Counter class
  *  - receives an Int values
  *  - method current count
  *  - method to increment/decrement => new Counter
  *  - overload inc/dec to receive an amount
  */
class Counter(val count: Int = 0) {
  def inc = new Counter(count + 1)
  def dec = new Counter(count - 1)

  def inc(n: Int): Counter = {
    if(n <= 0) this
    else inc.inc(n -1)
  }

  def dec(n: Int) : Counter = {
    if(n <= 0) this
    else dec.dec(n -1)
  }

  def print = println(count)
}
