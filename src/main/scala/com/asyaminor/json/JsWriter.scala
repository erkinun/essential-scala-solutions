package com.asyaminor.json

// 7.9.1 Convert X to JSON
trait JsWriter[T] {
  def write(t: T): JsValue
}

object JsUtil {
  def toJson[T](t: T)(implicit writer: JsWriter[T]): JsValue = writer.write(t)
}