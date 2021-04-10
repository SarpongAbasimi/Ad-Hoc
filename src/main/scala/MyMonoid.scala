/**
 * This is not really a perfect Monoid because A Monoid extends from a Semigroup( Which has the combine part of a Monoid).
 * Monoids in cats only have an empty method, they extend from Semigroup the combine method.
 */
import cats._
trait MyMonoid[T] {
  def combine(first: T, second: T): T
  def empty: T
}

object MyMonoidInstance {
  implicit val myMonoidForInt = new MyMonoid[Int] {
    def combine(first: Int, second: Int): Int =  {
      first + second
    }
    def empty: Int = 0
  }

  implicit val stringMonoid = new MyMonoid[String] {
    def combine(first: String, second: String): String = {
      first ++ second
    }

    def empty: String = ""
  }
}

/**
 * Red Book Monoid ex
 * Give Monoid instances for integer addition and multiplication as well as the Boolean operators.
 * */

object SecondInstances {
  val multiplicationInstance = new MyMonoid[Int] {
    def combine(first: Int, second:Int): Int = {
      first * second
    }

    def empty: Int = 1
  }

  def optionMonoid[A: Semigroup](implicit se: Semigroup[A]) = new MyMonoid[Option[A]] {
    def combine[A](first: Option[A], second: Option[A]): Option[A] = (first, second) match {
      case (Some(data), Some(otherData)) => Some(Semigroup.combine(data, otherData))
      case _ => ???
    }

    def empty[A]: Option[A] = None
  }
}

object MyMonoidInterface {
  def intCombine[T](valueOne: T, valueTwo: T)(implicit myMonoid: MyMonoid[T]): T = {
    myMonoid.combine(valueOne, valueTwo)
  }
}
