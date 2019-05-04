package com.asyaminor

import scala.util.Try

object OptionExercises {
  // 6.5.1.1 Adding Things
  def addOptions(opt1: Option[Int], opt2: Option[Int]): Option[Int] = {
    for {
      val1 <- opt1
      val2 <- opt2
    } yield val1 + val2
  }

  def addOptions2(opt1: Option[Int], opt2: Option[Int]): Option[Int] = {
    opt1.flatMap(a => opt2.map(b => a + b))
  }

  // 6.5.1.2 Adding All of the Things
  def addOptions(opt1: Option[Int], opt2: Option[Int], opt3: Option[Int]): Option[Int] = {
    for {
      val1 <- opt1
      val2 <- opt2
      val3 <- opt3
    } yield val1 + val2 + val3
  }

  // 6.5.1.3 A(nother) Short Division Exercise
  def divide(int1: Int, int2: Int): Option[Int] = {
    if (int2 == 0) { None }
    else { Some(int1 / int2) }
  }

  def divideOptions(opt1: Option[Int], opt2: Option[Int]): Option[Int] = {
    for {
      val1 <- opt1
      val2 <- opt2
      result <- divide(val1, val2)
    } yield result
  }

  // 6.5.1.4 A Simple Calculator
  def parseInt(s: String): Option[Int] = Try(s.toInt).fold(_ => None, i => Some(i))

  sealed trait Operator
  case object Add extends Operator
  case object Subtract extends Operator
  case object Multiply extends Operator
  case object Divide extends Operator

  def parseOperator(s: String): Option[Operator] = s match {
    case "+" => Some(Add)
    case "-" => Some(Subtract)
    case "*" => Some(Multiply)
    case "/" => Some(Divide)
    case _ => None
  }

  def evaluate(i1: Int, i2: Int, operator: Operator): Option[Int] = operator match {
    case Add => Some(i1 + i2)
    case Subtract => Some(i1 - i2)
    case Multiply => Some(i1 * i2)
    case Divide if i2 == 0 => None
    case Divide => Some(i1 / i2)
  }

  def calculator(operand1: String, operator: String, operand2: String): Unit = {
    val r = for {
      o1 <- parseInt(operand1)
      o2 <- parseInt(operand2)
      op <- parseOperator(operator)
      result <- evaluate(o1, o2, op)
    } yield result

    r.foldLeft(println("we couldn't calculate!"))((_, i) => println(s"result of the calculation: $i"))
  }
}
