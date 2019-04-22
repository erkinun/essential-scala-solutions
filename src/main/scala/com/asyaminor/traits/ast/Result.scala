package com.asyaminor.traits.ast

// 4.7.0.1 A Calculator
sealed trait Result {
  def +(that: Result): Result = (this, that) match {
    case (Success(v1), Success(v2)) => Success(v1 + v2)
    case (Fail(f), _) => Fail(f)
    case (_, Fail(f)) => Fail(f)
  }
  def -(that: Result): Result = (this, that) match {
    case (Success(v1), Success(v2)) => Success(v1 - v2)
    case (Fail(f), _) => Fail(f)
    case (_, Fail(f)) => Fail(f)
  }
  def /(that: Result): Result = (this, that) match {
    case (Success(v1), Success(v2)) =>
      if (v2 != 0) Success(v1 / v2)
      else Fail("Division by zero")
    case (Fail(f), _) => Fail(f)
    case (_, Fail(f)) => Fail(f)
  }
}
case class Success(v: Double) extends Result
case class Fail(msg: String) extends Result
