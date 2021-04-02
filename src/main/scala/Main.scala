import GenericShowInstances._
import EqualityInstances._

object Main {
  def main(args: Array[String]): Unit = {
    val PersonOne= PersonShow("Chris", 90)
    val result = GenericShowInterfaces.genericShow(PersonOne)
    val equalityForInt = EqualityInterfaces.intInterface(4, 5)
    println(result)
    println(equalityForInt)
  }
}
