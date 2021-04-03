/**
 * This is not really a perfect Monoid because A Monoid extends from a Semigroup( Which has the combine part of a Monoid).
 * Monoids in cats only have an empty method, they extend from Semigroup the combine method.
 */

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

object MyMonoidInterface {
  def intCombine[T](valueOne: T, valueTwo: T)(implicit myMonoid: MyMonoid[T]): T = {
    myMonoid.combine(valueOne, valueTwo)
  }
}
