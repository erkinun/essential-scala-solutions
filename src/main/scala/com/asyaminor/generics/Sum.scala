package com.asyaminor.generics

// 5.4.3.1 Exercise: Generic Sum Type
sealed trait Sum[T, U]
case class Left[T, U](value: T) extends Sum[T, U]
case class Right[T, U](value: U) extends Sum[T, U]
