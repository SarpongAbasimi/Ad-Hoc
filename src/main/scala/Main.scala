import GenericShowInstances._

object Main {
  def main(args: Array[String]): Unit = {
    val PersonOne= PersonShow("Chris", 90)
    val result = GenericShowInterfaces.genericShow(PersonOne)
    println(result)
  }
}
