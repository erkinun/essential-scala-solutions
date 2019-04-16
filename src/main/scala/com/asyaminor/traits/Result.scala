package com.asyaminor.traits

sealed trait Result[A]
final case class Success[A](result: A) extends Result[A]
final case class Failure[A](reason: String) extends Result[A]

//4.5.6.2
//object Calculator {
//  def +(calculation: Result, num: Int): Result = calculation match {
//    case Success(r) => Success(r + num)
//    case f @ Failure(_) => f
//  }
//
//  def -(calculation: Result, num: Int): Result = calculation match {
//    case Success(r) => Success(r - num)
//    case f @ Failure(_) => f
//  }
//
//  def /(calculation: Result, num: Int): Result = calculation match {
//    case Success(r) if num != 0 => Success(r / num)
//    case Success(_) if num == 0 => Failure("Division by zero")
//    case f @ Failure(_) => f
//  }
//}
