package com.asyaminor.generics

// 5.4.3.1 Exercise: Generic Sum Type
sealed trait Sum[T, U] {
  // 5.4.6.3 Folding Sum
  def fold[Z](left: T => Z)(right: U => Z): Z = this match {
    case Failure(value) => left(value)
    case Success(value) => right(value)
  }
}
// 5.5.4.4 Sum continued
case class Failure[T, U](value: T) extends Sum[T, U]
case class Success[T, U](value: U) extends Sum[T, U]
