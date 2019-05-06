package com.asyaminor.json

// 7.9.1 Convert X to JSON
trait JsWriter[T] {
  def write(t: T): JsValue
}

object JsWriter {
  // 7.9.2 Prettier Conversion Syntax
  implicit class JsUtil[T](t: T) {
    def toJson()(implicit writer: JsWriter[T]): JsValue = writer.write(t)
  }
}