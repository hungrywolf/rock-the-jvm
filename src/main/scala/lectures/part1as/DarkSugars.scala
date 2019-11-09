package lectures.part1as

object DarkSugars extends App {

  def singleArgMethod(arg: Int) : String = s"$arg little ducks ... "
  val description = singleArgMethod {
    42
  }

  println(description)
}
