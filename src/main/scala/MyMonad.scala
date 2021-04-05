trait MyMonad[F[_]] {

  def pure[A](value: A) : F[A]

  def flatMap[A, B](value: F[A])(func: A => F[B]): F[B]

  def map[A,  B](value: F[A])(func: A =>  B): F[B]

}

object MyMonadInstances {
  val listInstances = new MyMonad[List] {
    def pure[A](value: A): List[A] = {
      List(value)
    }

    def flatMap[A, B](value: List[A])(func: A => List[B]): List[B] = {
      value.flatMap(func)
    }

    def map[A, B](value: List[A])(func: A => B): List[B] = {
      this.flatMap(value)(a => this.pure(func(a)))
    }
  }
}