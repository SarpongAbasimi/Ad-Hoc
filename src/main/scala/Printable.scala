trait Printable[A] {
  def format      (value: A)       : String
  def contraMap[B](value: (A) => B): Printable[B]
}

object PrintableInstances {
  implicit val firstInstance = new Printable[String] {
    def format(value: String): String = value
    def contraMap[Int](value: (String) => Int): Printable[Int] = {
      ???
    }
  }
}
