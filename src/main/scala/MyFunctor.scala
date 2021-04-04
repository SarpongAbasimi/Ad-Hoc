trait MyFunctor[F[_]] {
  def map[A, B](someThing: F[A], secondThing: (A) => B): F[B]
}


object MyFunctorInstances {
  implicit val functorForLists = new MyFunctor[List] {
    def map[A, B](something: List[A], secondThing: (A) => B): List[B] = something.map(secondThing)
  }

  implicit val optionFunctor = new MyFunctor[Option] {
    def map[A, B](someThing: Option[A], secondThing: A => B): Option[B] = someThing.map(secondThing)
  }
}