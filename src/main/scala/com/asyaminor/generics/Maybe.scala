package com.asyaminor.generics

// 5.4.4.1 Exercise: Maybe that Was a Mistake
sealed trait Maybe[T]
case class Full[T](value: T) extends Maybe[T]
case class Empty[T]() extends Maybe[T]