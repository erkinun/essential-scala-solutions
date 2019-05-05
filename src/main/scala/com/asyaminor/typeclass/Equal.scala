package com.asyaminor.typeclass

// 7.3.4.1 Equality
trait Equal[A] {
  def equal(a1: A, a2: A): Boolean
}
