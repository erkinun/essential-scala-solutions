package com.asyaminor.random

// 6.10.2 Probabilities
case class Distribution[A](events: List[(A, Double)]) {
  def map[B](f: A => B): Distribution[B] = Distribution(events.map(e => f(e._1) -> e._2))
  def flatMap[B](f: A => Distribution[B]): Distribution[B] = {
    Distribution(events.flatMap { case (e, p) =>
      f(e).events map { case (e1, p2) => e1 -> (p * p2)} })
  }
}

object Distribution {
  def uniform[A](things: List[A]): Distribution[A] = Distribution(things.map(_ -> 1.0 / things.length))
}