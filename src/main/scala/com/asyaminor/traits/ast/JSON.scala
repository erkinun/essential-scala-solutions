package com.asyaminor.traits.ast

// 4.7.0.2 JSON
sealed trait JSON {
  override def toString: String = this match {
    case JsString(v) => "\"" + v + "\""
    case JsNumber(v) => v.toString
    case JsBoolean(v) => v.toString
    case JsNull => "null"
    case JsObject(fields) => s"{${fields.mkString(", ")}}"
    case JsArray(values) => s"[${values.mkString(", ")}]"
  }
}
case class JsString(value: String) extends JSON
case class JsNumber(value: Double) extends JSON
case class JsBoolean(value: Boolean) extends JSON
case class JsArray(values: Seq[JSON]) extends JSON
case class JsObject(fields: Seq[JsField]) extends JSON
case object JsNull extends JSON

case class JsField(name: String, value: JSON) {
  override def toString: String = "\"" + name + "\": " + value.toString
}
