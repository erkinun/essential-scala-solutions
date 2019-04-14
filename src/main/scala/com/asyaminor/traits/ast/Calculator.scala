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

sealed trait Expression {
  def eval: Result = this match {
    case Number(v) => Success(v)
    case Addition(l, r) => l.eval + r.eval
    case Subtraction(l, r) => l.eval - r.eval
    case Division(l, r) => l.eval / r.eval
    case SquareRoot(e) => e.eval match {
      case Success(v) =>
        if (v < 0.0) Fail("Square root of negative number")
        else Success(Math.sqrt(v))
      case f @ Fail(_) => f
    }
  }
}
case class Addition(left: Expression, right: Expression) extends Expression
case class Subtraction(left: Expression, right: Expression) extends Expression
case class Division(left: Expression, right: Expression) extends Expression
case class SquareRoot(expression: Expression) extends Expression
case class Number(value: Double) extends Expression

object Calculator {
}
