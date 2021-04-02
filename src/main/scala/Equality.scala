trait Equality[T] {
  def eq(firstThingToCompare:T, secondThingToCompare:T): Boolean
}

object EqualityInstances {
  implicit val intEquality = new Equality[Int] {
    def eq(valueOne: Int, valueTwo: Int): Boolean = {
      valueOne == valueTwo
    }
  }
}

object EqualityInterfaces {
  def intInterface[A](valueOne: A, valueTwo: A)(implicit equality: Equality[A]): Boolean = {
    equality.eq(valueOne, valueTwo)
  }
}