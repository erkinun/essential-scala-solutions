package com.asyaminor

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
}
