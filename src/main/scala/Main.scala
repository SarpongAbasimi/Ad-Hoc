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

    val someFood    = List(Some("Banku"), None, Some("Kenkey"), None, Some("Omotuo"))
    val secondFood  = List(None, None, Some("Kenkey"), None, Some("Omotuo"))
    val someNumbers = List(Some(1), Some(2), None, Some(5))

//    val theFunction  : (Option[String]) => String       = (data) => data.get // val is eager -> This will not compile
    val theMonadFunc : (Option[String]) => List[Option[String]] = (data) => List(data)

//    val theFunctor = Functor[List].map(someFood)(theFunction) // This will cause an error => None.get
    val theMonad = Monad[List].flatMap(secondFood)(theMonadFunc) // ???

    val answer = Monad[List].flatMap(someNumbers)(eachSome => List(Monoid.combine(eachSome, eachSome)))

    /**
     * Learning about the Eval Monad and came across this.
     *
     * Fun fact.
     *
     * Val in scala are eager and memoized.
     * Memoized means that
     *
     * val b = {
     * println("here")
     * math.random()
     * }
     * when b is called the first time and it returns for example 0.6078846269579766
     * the next time I call b, it will still return 0.6078846269579766
     *
     * sounds crazy right? Try it.
     * */
  }
}
