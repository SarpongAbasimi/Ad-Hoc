trait MyFunctor[F[_]] {
  def map[A, B](someThing: F[A], secondThing: (A) => B): F[B]
}


object MyFunctorInstances {
  implicit val functorForListOfIntsToString = new MyFunctor[List] {
    def map[A, B](something: List[A], secondThing: (A) => B): List[B] = something.map(secondThing)
  }
}