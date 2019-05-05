package com.asyaminor.typeclass

case class Person(name: String, email: String)

object Person {
  object PersonEqual extends Equal[Person] {
    override def equal(a1: Person, a2: Person): Boolean = a1.email == a2.email && a1.name == a1.name
  }
}

object EmailEquality {
  object EmailEqualityCheck extends Equal[Person] {
    override def equal(a1: Person, a2: Person): Boolean = a1.email == a2.email
  }
}