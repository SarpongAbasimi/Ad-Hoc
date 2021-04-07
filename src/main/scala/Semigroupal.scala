/**
 * so Semigroupal[Option](Some(123), Some("hello") = Some(123, "hello")
 *
 * Semigroups allow as to combine values whiles semigroupal allows
 * us to combine context.
 * */
trait Semigroupal[F[_]] {
  def product[A, B](firstValue: F[A], secondValue: F[B]): F[(A, B)]
}
