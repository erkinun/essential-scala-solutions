package com.asyaminor.traits.ast

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