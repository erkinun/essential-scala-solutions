package com.asyaminor.generics

// 5.4.3.1 Exercise: Generic Sum Type
sealed trait Sum[+T, +U] {

  // 5.5.4.4 Sum continued with map and flatMap
  def map[V](f: U => V): Sum[T, V] = this match {
    case Failure(value) => Failure(value)
    case Success(value) => Success(f(value))
  }

  // 5.6.4.1 Exercise: Covariant Sum
  def flatMap[TT >: T, V](f: U => Sum[TT, V]): Sum[TT, V] = this match {
    case Failure(value) => Failure(value)
    case Success(value) => f(value)
  }

  // 5.4.6.3 Folding Sum
  def fold[Z](left: T => Z)(right: U => Z): Z = this match {
    case Failure(value) => left(value)
    case Success(value) => right(value)
  }
}
// 5.5.4.4 Sum continued
case class Failure[T](value: T) extends Sum[T, Nothing]
case class Success[U](value: U) extends Sum[Nothing, U]
