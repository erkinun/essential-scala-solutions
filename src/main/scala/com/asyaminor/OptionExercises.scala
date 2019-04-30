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
}