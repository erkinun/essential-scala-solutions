package com.asyaminor.traits

sealed trait Calculation
final case class Success(result: Int) extends Calculation
final case class Failure(reason: String) extends Calculation

//4.5.6.2
object Calculator {
  def +(calculation: Calculation, num: Int): Calculation = calculation match {
    case Success(r) => Success(r + num)
    case f @ Failure(_) => f
  }

  def -(calculation: Calculation, num: Int): Calculation = calculation match {
    case Success(r) => Success(r - num)
    case f @ Failure(_) => f
  }

  def /(calculation: Calculation, num: Int): Calculation = calculation match {
    case Success(r) if num != 0 => Success(r / num)
    case Success(_) if num == 0 => Failure("Division by zero")
    case f @ Failure(_) => f
  }
}
