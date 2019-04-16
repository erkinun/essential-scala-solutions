package com.asyaminor.traits

// 5.1.3.1 Generic List
sealed trait LinkedList[A] {
  // 4.6.3.1 A List of Methods
  def length: Int = this match {
    case End() => 0
    case Pair(_, t) => 1 + t.length
  }

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
}
case class End[T]() extends LinkedList[T]
final case class Pair[T](head: T, tail: LinkedList[T]) extends LinkedList[T]
