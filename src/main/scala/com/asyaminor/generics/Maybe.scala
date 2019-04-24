package com.asyaminor.generics

// 5.4.4.1 Exercise: Maybe that Was a Mistake
sealed trait Maybe[T] {

  // 5.5.4.2 Mapping Maybe
  def map[U](fn: T => U): Maybe[U] = this match {
    case Empty() => Empty[U]()
    case Full(value) => Full(fn(value))
  }

  // 5.5.4.2 Mapping Maybe bonus points
  def mapBonus[U](fn: T => U): Maybe[U] = flatMap(t => Full(fn(t)))

  // 5.5.2 FlatMap
  def flatMap[U](fn: T => Maybe[U]): Maybe[U] = this match {
    case Empty() => Empty[U]()
    case Full(value) => fn(value)
  }

  // 5.4.6.2 Folding Maybe
  def fold[U](empty: => U)(full: T => U): U = this match {
    case Empty() => empty
    case Full(value) => full(value)
  }
}
case class Full[T](value: T) extends Maybe[T]
case class Empty[T]() extends Maybe[T]