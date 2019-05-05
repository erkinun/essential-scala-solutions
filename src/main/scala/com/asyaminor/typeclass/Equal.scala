package com.asyaminor.typeclass

// 7.3.4.1 Equality
trait Equal[A] {
  def equal(a1: A, a2: A): Boolean
}

// 7.6.3 Easy Equality
object Equal {
  implicit class EqualOps[A](a: A) {
    def ===(other: A)(implicit equal: Equal[A]): Boolean =
      equal.equal(a, other)
  }
}

object CaseInsensitive extends Equal[String] {
  override def equal(a1: String, a2: String): Boolean = a1.toLowerCase == a2.toLowerCase
}