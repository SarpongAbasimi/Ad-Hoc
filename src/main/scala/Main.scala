import GenericShowInstances._
import EqualityInstances._
import cats._
import cats.implicits._

object Main {
  def main(args: Array[String]): Unit = {
    val PersonOne= PersonShow("Chris", 90)
    val result = GenericShowInterfaces.genericShow(PersonOne)
    val equalityForInt = EqualityInterfaces.intInterface(4, 5)

    /** Understanding the difference between functors and Monads */

    val someFood   = List(Some("Banku"), None, Some("Kenkey"), None, Some("Omotuo"))
    val secondFood = List(None, None, Some("Kenkey"), None, Some("Omotuo"))

    val theFunction  : (Option[String]) => String       = (data) => data.get
    val theMonadFunc : (Option[String]) => List[Option[String]] = (data) => List(data)

    val theFunctor = Functor[List].map(someFood)(theFunction) // This will cause an error => None.get
    val theMonad = Monad[List].flatMap(secondFood)(theMonadFunc) // ???

  }
}
