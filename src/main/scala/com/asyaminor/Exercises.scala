package com.asyaminor

object Exercises {

  def fizzbuzz(n: Int): Seq[String] = {
    (0 to n).map(i => {
      if (i % 15 == 0) "fizzbuzz"
      else if (i % 5 == 0) "buzz"
      else if (i % 3 == 0) "fizz"
      else i.toString
    })
  }
}
