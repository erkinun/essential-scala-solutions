package com.asyaminor.traits.ast

import com.asyaminor.generics.Sum
import com.asyaminor.generics.Success
import com.asyaminor.generics.Failure

sealed trait Expression {
  // 5.6.6.2 Calculator Again
  def eval: Sum[String, Double] = this match {
    case Number(v) => Success(v)
    case Addition(l, r) => lift2(l, r, (l, r) => Success(l + r))
    case Subtraction(l, r) => lift2(l, r, (l , r) => Success(l - r))
    case Division(l, r) => lift2(l, r, (l, r) => {
      if (r == 0) {
        Failure("Division by zero")
      }
      else {
        Success(l / r)
      }
    })
    case SquareRoot(e) => e.eval match {
      case Success(v) =>
        if (v < 0.0) Failure("Square root of negative number")
        else Success(Math.sqrt(v))
      case f @ Failure(_) => f
    }
  }

  def lift2(left: Expression, right: Expression, fn: (Double, Double) => Sum[String, Double]): Sum[String, Double] = {
    left.eval.flatMap { l =>
      right.eval.flatMap { r =>
        fn(l, r)
      }
    }
  }
}
case class Addition(left: Expression, right: Expression) extends Expression
case class Subtraction(left: Expression, right: Expression) extends Expression
case class Division(left: Expression, right: Expression) extends Expression
case class SquareRoot(expression: Expression) extends Expression
case class Number(value: Double) extends Expression