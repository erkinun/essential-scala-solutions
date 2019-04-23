package com.asyaminor.generics

// 5.4.3.1 Exercise: Generic Sum Type
sealed trait Sum[T, U] {
  // 5.4.6.3 Folding Sum
  def fold[Z](left: T => Z)(right: U => Z): Z = this match {
    case Left(value) => left(value)
    case Right(value) => right(value)
  }
}
case class Left[T, U](value: T) extends Sum[T, U]
case class Right[T, U](value: U) extends Sum[T, U]
