package lectures.part2oop

import playgroud.{Cinderella => Princess, PrinceCharming}
import java.util.{Date => utilDate}
import java.sql.{Date => sqlDate}

object PackagingAndImports extends App {

  // package member are accessible by their simple name
  val writer = new Writer("saleh" , "rockthejvm" , 2019 )

  // import the package
   val prinecess = new Princess

  // package are in hierarchy
  // matching folder structure


  // package object
  sayHello
  println(SPEED_OF_LIGHT)

  // imports
  val prince = new PrinceCharming

  // 1. uew FQ names
  val d = new utilDate()
  val sqlDate = new sqlDate(2019,5,4)

  // 2. use aliasing

  // default import
  // java.lang - String, Object, Exception
  // scala - Int, Nothing, Function
  // scala.Predef - println, ???

}
