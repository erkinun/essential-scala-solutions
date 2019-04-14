package com.asyaminor.traits

// 4.6.3.2 The Forest of Trees
sealed trait Tree {
  def sum: Int
  def double: Tree
}
final case class Leaf(value: Int) extends Tree {
  override def sum: Int = value

  override def double: Tree = Leaf(value * 2)
}
final case class Node(left: Tree, right: Tree) extends Tree {
  override def sum: Int = left.sum + right.sum

  override def double: Tree = Node(left.double, right.double)
}

object TreeOps {
  def sum(tree: Tree): Int = tree match {
    case Leaf(v) => v
    case Node(l, r) => sum(l) + sum(r)
  }

  def double(tree: Tree): Tree = tree match {
    case Leaf(v) => Leaf(v * 2)
    case Node(l, r) => Node(double(l), double(r))
  }
}