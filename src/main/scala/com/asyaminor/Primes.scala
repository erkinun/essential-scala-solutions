package com.asyaminor

object Primes {
  def generate(limit: Int): Seq[Int] = {
    val infinity = Stream.from(1)
    infinity.filter(isPrime).take(limit)
  }

  def isPrime(num: Int): Boolean = num match {
    case 1 => false
    case 2 => true
    case _ =>
      val fermatNum = Math.pow(2, num - 1) - 1
      fermatNum % num == 0
  }

  def main(args: Array[String]): Unit = {
    val primes = generate(20).mkString(", ")
    println(s"the generated prime numbers for 100 primes: $primes")
  }
}
