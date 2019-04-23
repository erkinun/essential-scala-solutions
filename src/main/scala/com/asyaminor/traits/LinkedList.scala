package com.asyaminor.traits

// 5.1.3.1 Generic List
sealed trait LinkedList[A] {

  // 5.5.1 Map
  def map[B](fn: A => B): LinkedList[B] = this match {
    case End() => End()
    case Pair(h, t) => Pair(fn(h), t.map(fn))
  }

  // 4.6.3.1 A List of Methods
  def length: Int = fold(0, (_, len: Int) => len + 1)

  // 5.1.3.2 Working With Generic Types
  def contains(a: A): Boolean = this match {
    case End() => false
    case Pair(h, t) => if (a == h) {
      true
    } else {
      t.contains(a)
    }
  }

  def apply(n: Int): Result[A] = this match {
    case End() => Failure("Index out of bounds")
    case Pair(h, t) => if (n == 0) {
      Success(h)
    } else {
      t.apply(n - 1)
    }
  }

  // 5.2.3.1 A Better Abstraction
  def fold[B](end: B, f: (A, B) => B): B = this match {
    case End() => end
    case Pair(h, t) => f(h, t.fold(end, f))
  }
}
case class End[T]() extends LinkedList[T]
final case class Pair[T](head: T, tail: LinkedList[T]) extends LinkedList[T]
