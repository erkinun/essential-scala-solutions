package com.asyaminor.traits.ast

// 5.3.4.1 Tree
sealed trait Tree[T] {
  def fold[B](leaf: T => B)(node: (B, B) => B): B = this match {
    case Leaf(value) => leaf(value)
    case Node(left, right) => node(left.fold(leaf)(node), right.fold(leaf)(node))
  }

  override def toString: String = fold(value => value.toString)((left, right) => left + " " + right)
}
case class Leaf[T](value: T) extends Tree[T]
case class Node[T](left: Tree[T], right: Tree[T]) extends Tree[T]
